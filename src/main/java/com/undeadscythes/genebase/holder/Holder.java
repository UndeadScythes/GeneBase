package com.undeadscythes.genebase.holder;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.exception.NoValidTagException;
import com.undeadscythes.genebase.gedcom.GEDTag.Tag;
import com.undeadscythes.genebase.gedcom.GEDTag.TagType;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.metaturtle.Metadatable;
import com.undeadscythes.metaturtle.metadata.Metadata;
import com.undeadscythes.metaturtle.metadata.Property;
import com.undeadscythes.tipscript.TipScript;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * A convenience wrapper of the {@link Metadata} class.
 *
 * @author UndeadScythes
 */
public abstract class Holder extends Metadata {
    private static final long serialVersionUID = 1L;

    /**
     * Load this {@link Holder} with the data in the given {@link Cluster}.
     *
     * @deprecated Use {@link #Holder(NamedTag, Cluster) Holder(NamedTag, Cluster)}
     */
    @Deprecated
    public Holder(final Cluster cluster) {
        this(cluster.pullHead().tag, cluster.pullHead().value);
        load(cluster);
    }

    /**
     * Load this {@link Holder} with the data in the given {@link Cluster}.
     */
    public Holder(final NamedTag tag, final Cluster cluster) {
        this(tag, cluster.pullHead().value);
        load(cluster);
    }

    /**
     * Convenience constructor to pass a {@link Tag}.
     *
     * @see #Holder(NamedTag, Cluster) Holder(NamedTag, Cluster)
     */
    public Holder(final Tag tag, final Cluster cluster) {
        this(tag.getGEDTag(), cluster.pullHead().value);
        load(cluster);
    }

    /**
     * @see Metadata#Metadata(String, String)
     *
     * @deprecated Use {@link #Holder(Property, String) Holder(Property, String)}
     */
    @Deprecated
    public Holder(final String property, final String value) {
        super(property, value);
    }

    /**
     * @see Metadata#Metadata(String, String)
     */
    public Holder(final Property property, final String value) {
        super(property, value);
    }

    /**
     * Specific constructor for when a sub class overrides the
     * {@link #getValue() getValue()} method.
     *
     * @see Metadata#Metadata(String, String)
     */
    public Holder(final Property property) {
        super(property.toString(), "OVERRIDDEN");
    }

    /**
     * Load a generic {@link Metadatable} with the values of the given
     * {@link Cluster}.
     */
    public final void load(final Cluster cluster) {
        while (cluster.hasNext()) {
            final Cluster next = cluster.pullCluster();
            NamedTag tag;
            final String nextTag;
            nextTag = next.getTag();
            try {
                tag = GEDTag.getByName(nextTag);
            } catch (NoValidTagException ex) {
                final CustomTag custom = new CustomTag(nextTag);
                GEDTag.addTag(custom);
                tag = custom;
            }
            try {
                add(tag.getStructure().getConstructor(Cluster.class).newInstance(next));
            } catch (NoSuchMethodException ex) {
                throw new RuntimeException(tag.getFormal(), ex);
            } catch (SecurityException ex) {
                throw new RuntimeException(tag.getFormal(), ex);
            } catch (InstantiationException ex) {
                throw new RuntimeException(tag.getFormal(), ex);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(tag.getFormal(), ex);
            } catch (IllegalArgumentException ex) {
                throw new RuntimeException(tag.getFormal(), ex);
            } catch (InvocationTargetException ex) {
                throw new RuntimeException(tag.getFormal(), ex);
            }
        }
    }

    /**
     * Output the contents of this {@link Holder} to the given
     * {@link TipScript} file.
     */
    public void dump(final TipScript out, final String prefix) {
        final StringBuilder newLine = new StringBuilder("\n  ");
        for (int i = 0; i < prefix.length() + getProperty().toString().length(); i++) {
            newLine.append(" ");
        }
        out.printf(prefix + getProperty() + ": " + getValue().replace("\n", newLine.toString()));
        for (Metadata data : this) {
            if (data instanceof Holder) {
                ((Holder)data).dump(out, "  " + prefix);
            } else {
                out.printf("Unreadable metadata: " + data.getProperty() + ": " + data.getValue());
            }
        }
    }

    /**
     * Get the contents of this {@link Holder}.
     */
    public String dump(final String prefix) {
        final StringBuilder newLine = new StringBuilder("\n  ");
        for (int i = 0; i < prefix.length() + getProperty().toString().length(); i++) {
            newLine.append(" ");
        }
        final StringBuilder result = new StringBuilder(prefix).append(getProperty()).append(": ").append(getValue().replace("\n", newLine.toString())).append("\n");
        for (Metadata data : this) {
            if (data instanceof Holder) {
                result.append(((Holder)data).dump("  " + prefix));
            } else {
                result.append("Unreadable metadata: ").append(data.getProperty()).append(": ").append(data.getValue()).append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Save the contents of this {@link Holder} to a {@link GEDCOM} format in
     * the file given in the {@link TipScript}.
     */
    public void save(final TipScript out, final int level) {
        final String value = getValue().replaceAll("@", "@@");
        out.printf(level + " " + getProperty() + (value.isEmpty() ? "" : " " + value));
        for (Metadata data : this) {
            ((Holder)data).save(out, level + 1);
        }
    }

    /**
     * Get a list of {@link Metadata} with a given property {@link TagType}.
     */
    public List<Metadata> getListByType(final TagType type) {
        final List<Metadata> list = new ArrayList<Metadata>(0);
        for (Metadata data : this) {
            if (GEDTag.getByName(data.getProperty().toString()).getType().equals(type)) list.add(data);
        }
        return list;
    }

    /**
     * Get the formal name of the property of this {@link Holder}.
     */
    public String getFormal() {
        return ((NamedTag)getProperty()).getFormal();
    }

    /**
     * Get a friendly {@link String} representing the value of this
     * {@link Holder}.
     */
    public abstract String getFriendly();

    @Override
    public final String toString() {
        return getValue();
    }
}
