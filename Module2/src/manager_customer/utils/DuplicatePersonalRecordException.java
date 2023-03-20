package manager_customer.utils;

import manager_customer.controller.PersonController;

public class DuplicatePersonalRecordException extends Exception{
    public DuplicatePersonalRecordException(String errorLine) {
        super(errorLine);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public static void checkIdCorrectType(PersonController personController, String id) throws DuplicatePersonalRecordException{
        if (personController.searchById(id) != null) throw new DuplicatePersonalRecordException("id is correct");

    }
    public static void checkIdIsExist(PersonController personController, String id) throws DuplicatePersonalRecordException{
        if (personController.isNotExistPerson(id)) throw new DuplicatePersonalRecordException("id not EXIST");
    }
}
