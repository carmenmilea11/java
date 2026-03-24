//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    double[] prices = new double[] {10, 11, 9};
    int[] units = new int[] {12, 8, 9};
    String[] descs = new String[] {"T-Shirt", "Mug", "Pen"};

    Invoice myInvoice = new Invoice(prices, units, descs);
    myInvoice.saveInvoice2File("test3.txt");
    myInvoice.readInvoiceFromFileAndCalcTotal("test3.txt");

}
