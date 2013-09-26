package com.undeadscythes.genebase.holder;

import com.undeadscythes.gedform.*;
import com.undeadscythes.genebase.gedcom.*;
import com.undeadscythes.metaturtle.metadata.*;
import com.undeadscythes.metaturtle.unique.*;
import com.undeadscythes.tipscript.*;
import java.util.*;

/**
 * A convenience wrapper of the {@link UniqueMeta} class.
 *
 * @author UndeadScythes
 */
public class UniqueHolder extends UniqueMeta {
    private static final long serialVersionUID = 1L;

    /**
     * Construct a {@link UniqueMeta} with a given {@link RecordType} and UID.
     */
    public UniqueHolder(final RecordType type, final String uid) {
        super(type, uid);
    }

    /**
     * Load a {@link UniqueHolder} from a {@link Cluster}.
     */
    public UniqueHolder(final RecordType type, final Cluster cluster) {
        this(type, cluster.pullHead().xref);
        Holder.load(this, cluster);
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
            if (data.equals(property.getString())) matches.add(data);
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
}
