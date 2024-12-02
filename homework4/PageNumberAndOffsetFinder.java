package homework4;

public class PageNumberAndOffsetFinder implements PageNumberPageOffSetInterface {
    private int virtualAddress;
    private int pageSize;

    public PageNumberAndOffsetFinder() {
        this.virtualAddress = getVirtualAddress();
        this.pageSize = getPageSize();
    }

    public PageNumberAndOffsetFinder(int virtualAddress) {
        setVirtualAddress(virtualAddress);
    }

    public PageNumberAndOffsetFinder(int virtualAddress, int pageSize) {
        setVirtualAddress(virtualAddress);
        setPageSize(pageSize);
    }

    // This method returns the virtual address
    @Override
    public int getVirtualAddress() {
        return this.virtualAddress;
    }

    // This method is used to set the virtual address.
    @Override
    public void setVirtualAddress(int virtualAddress) {
        this.virtualAddress = Math.max(virtualAddress, 0);
    }

    // This method gets and returns the page size of the memory.
    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    // This method is used to set the page size of the memory.
    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = Math.max(pageSize, 0); // Assuming the input values are {512, 1024, 4096} in byte/octet
    }

    // This method computes and returns a page number based on the virtual address and page size.
    @Override
    public int getPageNumber() {
        return this.virtualAddress / this.pageSize; // Page Number = Virtual Address / Page Size
    }

    // This method computes and returns a page offset based on the virtual address and page size.
    @Override
    public int getPageOffset() {
        return this.virtualAddress % this.pageSize; // Virtual Address % Page Size
    }
}
