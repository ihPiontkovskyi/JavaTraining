package ua.epam.training.piontkovskyi.task3_2.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Shop {
    private String name;
    private List<Department> departments;

    public Shop(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    public List<Department> getDepartments() {
        ArrayList<Department> copied = new ArrayList<>(departments.size());
        copied.addAll(departments);
        return copied;
    }

    public boolean removeDepartment(int index) {
        if (index > departments.size() || index < 0) {
            return false;
        }
        departments.remove(index);
        return true;
    }

    public void sort(String parameter) {
        if (SortParameter.NAME.checkEqual(parameter)) {
            departments.sort(new Comparator<Department>() {
                @Override
                public int compare(Department o1, Department o2) {
                    return o1.name.compareTo(o2.name);
                }
            });
        }
        if (SortParameter.PRODUCT_TYPE.checkEqual(parameter)) {
            departments.sort(new Comparator<Department>() {
                @Override
                public int compare(Department o1, Department o2) {
                    return o1.productType.compareTo(o2.productType);
                }
            });
        }
        if (SortParameter.LOCATION.checkEqual(parameter)) {
            departments.sort(new Comparator<Department>() {
                @Override
                public int compare(Department o1, Department o2) {
                    return o1.location.compareTo(o2.location);
                }
            });
        }
        if (SortParameter.SERVICES_COUNT.checkEqual(parameter)) {
            departments.sort(new Comparator<Department>() {
                @Override
                public int compare(Department o1, Department o2) {
                    return o1.services.size() - o2.services.size();
                }
            });
        }
    }

    public String performOperation(int index) {
        if (index > departments.size() || index < 0) {
            return null;
        }
        return departments.get(index).performOperation();
    }

    private class Department {
        private String name;
        private String productType;
        private List<String> services;
        private String location;

        private Department() {
            services = new ArrayList<>();
        }

        private String performOperation() {
            return "Department '" +
                    name +
                    "' perform operation with product type '" +
                    productType +
                    "' at " +
                    location +
                    " used " +
                    services.get(new Random().nextInt(services.size()));
        }

        @Override
        public String toString() {
            return "\n\tDepartment{" +
                    "name=" + name +
                    ", productType=" + productType +
                    ", services=" + services +
                    ", location=" + location +
                    "}";
        }
    }

    public class DepartmentBuilder {
        private Department department = new Department();

        public void withName(String name) {
            department.name = name;
        }

        public void withProductType(String productType) {
            department.productType = productType;
        }

        public void withLocation(String location) {
            department.location = location;
        }

        public void addService(String service) {
            department.services.add(service);
        }

        public void buildDepartment() {
            departments.add(department);
        }

    }

    @Override
    public String toString() {
        return "Shop:" +
                "name=" + name +
                ", departments=" + departments + "\n";
    }
}
