package recipes.business;

import org.springframework.stereotype.Service;

@Service
public class IdGenerator {

    private int currentId = 1;

    public synchronized int getNextId() {
        final int id = currentId;
        currentId++;
        return id;
    }
}
