// create Invoice class which contains:
// A. Fields:
// A.1 - prices: double[]
// A.2 - units: int[]
// A.3 - descs: String[] - descriptions of the products within invoice
// B. Methods:
// B.1 - constructor: public Invoice(int[] units, double[] prices, String[] productsDesc)
// B.2 - get and set methods
// B.3 - public void saveInvoice2File(String invoiceFileName) - save the invoice values (in order of the described fields)
// into a file
// B.4 - public double readInvoiceFromFileAndCalcTotal(String invoiceFileName) - read from the file and calculate
// the total of the invoice
// B.5 - clone method for deep copy

import java.io.*;

public class Invoice implements Cloneable {
    private double[] prices;
    private int[] units;
    private String[] descs;

    public Invoice(double[] prices, int[] units, String[] descs) {
        this.prices = prices;
        this.units = units;
        this.descs = descs;
    }

    public double[] getPrices() {
        return prices;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }

    public int[] getUnits() {
        return units;
    }

    public void setUnits(int[] units) {
        this.units = units;
    }

    public String[] getDescs() {
        return descs;
    }

    public void setDescs(String[] descs) {
        this.descs = descs;
    }

    public void saveInvoice2File(String invoiceFileName) {
        try (DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(invoiceFileName))))
        {
            for (int i = 0; i < prices.length; i++) {
                ds.writeDouble(prices[i]);
                ds.writeInt(units[i]);
                ds.writeUTF(descs[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double readInvoiceFromFileAndCalcTotal(String invoiceFileName) {
        double total = 0;
        DataInputStream ds = null;
        try {
            FileInputStream fs = new FileInputStream(invoiceFileName);
            BufferedInputStream bs = new BufferedInputStream(fs);
            ds = new DataInputStream(bs);

            double price;
            int unit;
            String desc;

            try {
                while (true) {
                    price = ds.readDouble();
                    unit = ds.readInt();
                    desc = ds.readUTF();
                    total += price * unit;
                    System.out.println("price " + price + " unit " + unit + " desc " + desc);
                }

            } catch (EOFException eof) {
                System.out.println(total);
                ds.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return total;
    }

    @Override
    public Invoice clone() {
        try {
            Invoice clone = (Invoice) super.clone();
            clone.descs = this.descs.clone();
            clone.units = this.units.clone();
            clone.prices = this.prices.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
