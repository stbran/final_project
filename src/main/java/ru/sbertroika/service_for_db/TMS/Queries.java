package ru.sbertroika.service_for_db.TMS;

public enum Queries {
    SELECT_TERMINAL_LIST ("select * from terminal"),
    SELECT_TYPE_LIST ("select * from terminal_type"),
    SELECT_ORGANIZATION_LIST ("select * from organization"),
    SELECT_ORGANIZATION_BY_ID ("select o_name from organization where o_id = ?"),
    SELECT_TYPE_BY_ID ("select tt_name from terminal_type where tt_id = ?"),
    SELECT_ID_TERMINAL_BY_NAME ("select t_id from terminal where t_title = ?"),
    SELECT_ID_TYPE_BY_NAME ("select tt_id from terminal_type where tt_name = ?"),
    SELECT_ID_ORGANIZATION_BY_NAME ("select o_id from organization where o_name = ?"),
    DELETE_TERMINAL_BY_ID ("delete from terminal where t_id = ?"),
    DELETE_TYPE_BY_ID ("delete from terminal_type where tt_id = ?"),
    DELETE_ORGANIZATION_BY_ID ("delete from organization where o_id = ?"),
    DELETE_TERMINAL_BY_SN ("delete from terminal where t_serial_number = ?");

    private String value;
    Queries(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
