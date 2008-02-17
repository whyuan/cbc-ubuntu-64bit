package net.loveruby.cflat.ast;
import net.loveruby.cflat.type.*;
import net.loveruby.cflat.asm.*;

abstract public class Variable extends Entity {
    protected long sequence;
    protected AsmEntity address;

    public Variable(boolean priv, TypeNode type, String name) {
        super(priv, type, name);
        sequence = -1;
    }

    public void setSequence(long seq) {
        this.sequence = seq;
    }

    public String symbol() {
        return (sequence < 0) ? name : (name + "." + sequence);
    }

    public void setAddress(AsmEntity addr) {
        address = addr;
    }

    public AsmEntity address() {
        if (address == null)
            throw new Error("unresolved variable address");
        return address;
    }
}
