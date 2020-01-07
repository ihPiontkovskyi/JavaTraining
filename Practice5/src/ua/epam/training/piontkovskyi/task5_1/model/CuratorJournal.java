package ua.epam.training.piontkovskyi.task5_1.model;

import java.util.ArrayList;
import java.util.List;

public class CuratorJournal {
    private List<Record> recordList = new ArrayList<>();

    public void add(Record record) {
        recordList.add(record);
    }

    public List<Record> getRecordList() {
        return recordList;
    }
}
