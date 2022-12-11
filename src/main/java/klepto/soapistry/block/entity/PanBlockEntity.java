package klepto.soapistry.block.entity;

import org.jetbrains.annotations.Nullable;

import klepto.soapistry.item.inventory.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class PanBlockEntity extends BlockEntity implements ImplementedInventory{

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    private int number = 1;
    
    public PanBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocksEntities.PAN_BLOCK_ENTITY, pos, state);
    }

    public ItemStack getRenderStack() {
        return this.getStack(0);
    }

    public void setInventory(DefaultedList<ItemStack> inventory) {
            this.inventory.set(0, inventory.get(0));
    }

    
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }


    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
    
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        number = nbt.getInt("number");
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("number", number);
        Inventories.writeNbt(nbt,inventory);
    }
}
