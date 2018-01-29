INSERT INTO role (role_id, role_name) VALUES (ROLE_SEQ.nextval, 'ADMIN');

insert into app_user (APUS_ID, APUS_NAME, APUS_ADDRESS, APUS_DOCUMENT, APUS_PHONE, APUS_ENTRY_DATE, APUS_USERNAME, APUS_ADMIN) 
values (APP_USER_SEQ.nextval, "Nicolas", "Valdenegro 3436", "40242343", "1560113877", sysdate, "condenl", 1);

insert into vehicle_family (VEFA_ID, VEFA_NAME, VEFA_DIMENSION) values (VEHICLE_FAMILY_SEQ.nextval, 'Caravan', 'SMALL');
insert into vehicle_family (VEFA_ID, VEFA_NAME, VEFA_DIMENSION) values (VEHICLE_FAMILY_SEQ.nextval, 'Motorhome', 'MEDIUM');
insert into vehicle_family (VEFA_ID, VEFA_NAME, VEFA_DIMENSION) values (VEHICLE_FAMILY_SEQ.nextval, 'Trailer', 'MEDIUM');
insert into vehicle_family (VEFA_ID, VEFA_NAME, VEFA_DIMENSION) values (VEHICLE_FAMILY_SEQ.nextval, 'TrailerTowing', 'BIG');

insert into zone (ZONE_ID, ZONE_LETTER, ZONE_VEFA_ID, ZONE_KIGA_ID) values (zone_seq.nextval, 'A', 1, null);
insert into zone (ZONE_ID, ZONE_LETTER, ZONE_VEFA_ID, ZONE_KIGA_ID) values (zone_seq.nextval, 'B', 2, null);
insert into zone (ZONE_ID, ZONE_LETTER, ZONE_VEFA_ID, ZONE_KIGA_ID) values (zone_seq.nextval, 'C', 3, null);
insert into zone (ZONE_ID, ZONE_LETTER, ZONE_VEFA_ID, ZONE_KIGA_ID) values (zone_seq.nextval, 'D', 4, null);