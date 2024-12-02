import homework4.PageNumberAndOffsetFinder;

public class Main {
    public static String display(PageNumberAndOffsetFinder p) {
        return String.format(
                """
                        addresses %d for a page size of %dKB (%d bytes)
                        page number = %d
                        offset = %d
                        """,
                p.getVirtualAddress(), (p.getPageSize() / 1000), p.getPageSize(),
                p.getPageNumber(), p.getPageOffset());
    }

    public static void main(String[] args) {
        PageNumberAndOffsetFinder t = new PageNumberAndOffsetFinder(19986, 4096);
//        t.setVirtualAddress(19986);
//        t.setPageSize(512);
        System.out.println(display(t));
    }
}
