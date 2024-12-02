package homework4;

public class RelocationRegisterAddressTranslator implements PhysicalAddressRelocationRegisterInterface {
    private int virtualAddress;
    private int relocationRegister;
    private int limitRegister;

    public RelocationRegisterAddressTranslator(){
        this.virtualAddress = getVirtualAddress();
        this.relocationRegister = getRelocationRegister();
        this.limitRegister = getLimitRegister();
    }

    public RelocationRegisterAddressTranslator(int virtualAddress){
        setVirtualAddress(virtualAddress);
        this.relocationRegister = getRelocationRegister();
        this.limitRegister = getLimitRegister();
    }

    public RelocationRegisterAddressTranslator(int virtualAddress, int relocationRegister, int limitRegister){
        setVirtualAddress(virtualAddress);
        setRelocationRegister(relocationRegister);
        setLimitRegister(limitRegister);
    }

    @Override
    public int getVirtualAddress() {
        return this.virtualAddress;
    }

    @Override
    public void setVirtualAddress(int virtualAddress) {
        this.virtualAddress = Math.max(virtualAddress, 0);
    }

    @Override
    public int getRelocationRegister() {
        return this.relocationRegister;
    }

    @Override
    public void setRelocationRegister(int relocationRegister) {
        this.relocationRegister = Math.max(relocationRegister, 0);
    }

    @Override
    public int getLimitRegister() {
        return this.limitRegister;
    }

    @Override
    public void setLimitRegister(int limitRegister) {
        this.limitRegister = Math.max(limitRegister, 0);
    }

    // Computes the physical address based on the virtual address, using a relocation register and a limit register.
    @Override
    public int computePhysicalAddress() {
        if (virtualAddress >= this.limitRegister) {
            throw new IllegalArgumentException("The virtual address exceeds the limit register.");
        }
        return this.virtualAddress + relocationRegister;
    }
}
