package com.undeadscythes.genebase.holder;

import com.undeadscythes.gedform.Cluster;
import com.undeadscythes.genebase.exception.NoValidTagException;
import com.undeadscythes.genebase.gedcom.GEDTag.Tag;
import com.undeadscythes.genebase.gedcom.GEDTag.TagType;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.genebase.structure.*;
import com.undeadscythes.metaturtle.Metadatable;
import com.undeadscythes.metaturtle.metadata.Metadata;
import com.undeadscythes.metaturtle.metadata.Property;
import com.undeadscythes.metaturtle.unique.UID;
import com.undeadscythes.metaturtle.unique.UniqueMeta;
import com.undeadscythes.tipscript.TipScript;
import java.util.*;

/**
 * A convenience wrapper of the {@link UniqueMeta} class.
 *
 * @author UndeadScythes
 */
public abstract class UniqueHolder extends UniqueMeta {
    private static final long serialVersionUID = 1L;

    /**
     * Construct a {@link UniqueMeta} with a given {@link RecordType} and UID.
     */
    public UniqueHolder(final RecordType type, final String uid) {
        super(type, uid);
    }

    /**
     * Construct a {@link UniqueMeta} with a given {@link RecordType} and UID.
     */
    public UniqueHolder(final RecordType type, final UID uid) {
        super(type, uid);
    }

    /**
     * Load a {@link UniqueHolder} from a {@link Cluster}.
     */
    public UniqueHolder(final RecordType type, final Cluster cluster) {
        this(type, cluster.pullHead().xref);
        load(cluster);
    }

    /**
     * Output the contents of this {@link UniqueHolder} to the given
     * {@link TipScript} file.
     */
    public void dump(final TipScript out, final String prefix) {
        out.printf(prefix + getType().toString() + ": " + getUID());
        for (Metadata data : this) {
            ((Holder)data).dump(out, "  " + prefix);
        }
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
            if (tag.getType().equals(TagType.EVENT)) {
                add(new Event(tag, next));
            } else if (tag.equals(Tag.NAME.getGEDTag())) {
                add(new Name(next));
            } else {
                add(new Fact(tag, next));
            }
        }
    }

    /**
     * Get the contents of this {@link UniqueHolder}.
     */
    public String dump(final String prefix) {
        final StringBuilder result = new StringBuilder(prefix).append(getType().toString()).append(": ").append(getUID()).append("\n");
        for (Metadata data : this) {
            result.append(((Holder)data).dump("  " + prefix));
        }
        return result.toString();
    }

    /**
     * Get a sorted list of {@link Metadata} with a property equals to the given
     * {@link Property}.
     */
    public List<Metadata> getSortedList(final Property property, final Comparator<Metadata> comp) {
        final List<Metadata> matches = new ArrayList<Metadata>(0);
        for (Metadata data : this) {
            if (data.isProperty(property)) matches.add(data);
        }
        Collections.sort(matches, comp);
        return matches;
    }

    /**
     * Save the contents of this {@link UniqueHolder} to a {@link GEDCOM} format
     * in the file given in the {@link TipScript}.
     */
    public void save(final TipScript out, final int level) {
        out.printf(level + " @" + getUID() + "@ " + getType());
        for (Metadata data : this) {
            ((Holder)data).save(out, level + 1);
        }
    }

    /**
     * Get a list of {@link Metadata} with a given property {@link TagType}.
     */
    public List<Holder> getListByType(final TagType type) {
        final List<Holder> list = new ArrayList<Holder>(0);
        for (Metadata data : this) {
            if (((NamedTag)data.getProperty()).getType().equals(type)) list.add((Holder)data);
        }
        return list;
    }
}
