package ua.yet.adv.java.generics.domain;

public class Phone extends Product<Phone> {

    private String model;

    public Phone(String name) {
        super(name);
    }

    @Override
    protected int deepCompare(Phone phone) {
        if (phone != null) {
            if (model == null && phone.model == null) {
                return 0;
            } else if (model != null) {
                return model.compareTo(phone.model);
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
