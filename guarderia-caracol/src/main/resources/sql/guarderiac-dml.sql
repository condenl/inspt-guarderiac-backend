INSERT INTO role (role_id, role_name) VALUES (ROLE_SEQ.nextval, 'ADMIN');

insert into app_user (APUS_ID, APUS_NAME, APUS_ADDRESS, APUS_DOCUMENT, APUS_PHONE, APUS_ENTRY_DATE, APUS_USERNAME, APUS_ADMIN) 
values (APP_USER_SEQ.nextval, 'Nicolas', 'Triunvirato 3000', '40242343', '1560113877', sysdate, 'condenl', 1);

insert into vehicle_family (VEFA_ID, VEFA_NAME, VEFA_DIMENSION) values (VEHICLE_FAMILY_SEQ.nextval, 'Caravan', 'SMALL');
insert into vehicle_family (VEFA_ID, VEFA_NAME, VEFA_DIMENSION) values (VEHICLE_FAMILY_SEQ.nextval, 'Motorhome', 'MEDIUM');
insert into vehicle_family (VEFA_ID, VEFA_NAME, VEFA_DIMENSION) values (VEHICLE_FAMILY_SEQ.nextval, 'Trailer', 'MEDIUM');
insert into vehicle_family (VEFA_ID, VEFA_NAME, VEFA_DIMENSION) values (VEHICLE_FAMILY_SEQ.nextval, 'TrailerTowing', 'BIG');

insert into zone (ZONE_ID, ZONE_LETTER, ZONE_VEFA_ID, ZONE_KIGA_ID) values (zone_seq.nextval, 'A', 1, null);
insert into zone (ZONE_ID, ZONE_LETTER, ZONE_VEFA_ID, ZONE_KIGA_ID) values (zone_seq.nextval, 'B', 2, null);
insert into zone (ZONE_ID, ZONE_LETTER, ZONE_VEFA_ID, ZONE_KIGA_ID) values (zone_seq.nextval, 'C', 3, null);
insert into zone (ZONE_ID, ZONE_LETTER, ZONE_VEFA_ID, ZONE_KIGA_ID) values (zone_seq.nextval, 'D', 4, null);

alter table guarderiac.vehicle add (vehi_phot_id number(19, 0));

create table guarderiac.photo(
	PHOT_ID number (19, 0),
	PHOT_DATA BLOB,
	constraint photo_pk primary key (PHOT_ID);
);

create sequence guarderiac.photo_seq;

grant all on guarderiac.photo to guarderiac;
grant all on guarderiac.photo_seq to guarderiac;