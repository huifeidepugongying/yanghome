package mybatis.entity;

import java.util.Objects;

public class OldNewProp {
    private Integer oldVal;
    private Integer newVal;

    public Integer getOldVal() {
        return oldVal;
    }

    public void setOldVal(Integer oldVal) {
        this.oldVal = oldVal;
    }

    public Integer getNewVal() {
        return newVal;
    }

    public void setNewVal(Integer newVal) {
        this.newVal = newVal;
    }

    @Override
    public String toString() {
        return "OldNewProp{" +
                "oldVal=" + oldVal +
                ", newVal=" + newVal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldNewProp that = (OldNewProp) o;
        return Objects.equals(oldVal, that.oldVal) &&
                Objects.equals(newVal, that.newVal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oldVal, newVal);
    }
}
