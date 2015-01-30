package net.minecraft.server;

public class TileEntityRecordPlayer extends TileEntity {

    private ItemStack record;

    public TileEntityRecordPlayer() {}

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        if (nbttagcompound.hasKeyOfType("RecordItem", 10)) {
            this.setRecord(ItemStack.createStack(nbttagcompound.getCompound("RecordItem")));
        } else if (nbttagcompound.getInt("Record") > 0) {
            this.setRecord(new ItemStack(Item.getById(nbttagcompound.getInt("Record")), 1, 0));
        }

    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        if (this.getRecord() != null) {
            nbttagcompound.set("RecordItem", this.getRecord().save(new NBTTagCompound()));
        }

    }

    public ItemStack getRecord() {
        return this.record;
    }

    public void setRecord(ItemStack itemstack) {
        this.record = itemstack;
        this.update();
    }
}
