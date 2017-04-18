drop schema if exists connections;

create schema if not exists contacts;
drop table if exists contacts.contact;
create table if not exists contacts.contact (
     ID bigint identity   
    ,COMPANY nvarchar(50)
    ,FIRST_NAME nvarchar(30)
    ,LAST_NAME nvarchar(30)
    ,ADDRESS nvarchar(100)
    ,ADDRESS2 nvarchar(100)
    ,CITY nvarchar(50)
    ,PROVENCE nvarchar(20)
    ,POSTCODE nvarchar(10)
    ,COUNTRY nvarchar(2)
    ,CONTACT nvarchar(40)
    ,CELL_PHONE nvarchar(20)
    ,LAND_PHONE nvarchar(20)
    ,FAX_PHONE nvarchar(20)
    ,EMAIL nvarchar(128)
    ,SKYPE nvarchar(128)
    ,LINKEDIN nvarchar(128)
    ,FACEBOOK nvarchar(128)
    ,TWITTER nvarchar(128)
    ,WEBSITE nvarchar(128)
    ,MISC nvarchar(128)
    ,CUSTOMER boolean
    ,SUPPLIER boolean
    ,TAXABLE1 boolean
    ,TAXABLE2 boolean
);

drop table if exists contacts.shipaddress;
create table if not exists contacts.shipaddress (

    ID bigint identity 
    ,contact_id bigint
    ,COMPANY nvarchar(50)
    ,CONTACT nvarchar(30)
    ,ADDRESS nvarchar(100)
    ,ADDRESS2 nvarchar(100)
    ,CITY nvarchar(50)
    ,PROVENCE nvarchar(20)
    ,POSTCODE nvarchar(10)
    ,COUNTRY nvarchar(2)
    ,PHONE nvarchar(20)
    ,isDefault boolean default(0)
    
);

ALTER TABLE IF EXISTS contacts.shipaddress ADD FOREIGN KEY (contact_id) REFERENCES contacts.contact (id);


create schema if not exists inventory;
drop table if exists inventory.inventory;
create table if not exists inventory.inventory(

    ID bigint identity
    ,UPC nvarchar(20)
    ,CODE nvarchar(64)
    ,DESCRIPTION nvarchar(120)
    ,NOTE nvarchar(2000)
    ,SIZE nvarchar(20)
    ,WEIGHT nvarchar(20)
    ,QUANTITY decimal(19,4)
    ,COST decimal(19,4)
    ,PRICE decimal(19,4)
    ,CATEGORY nvarchar(30)
    ,TAXABLE1 boolean default(1)
    ,TAXABLE2 boolean default(1)
    ,AVAILABLE boolean default(1)
    ,CUTOFF decimal(19,4)
    ,PARTIAL_SALE boolean default(0)
    ,returnPeriodInDays int
);

drop table if exists inventory.supplier;
create table if not exists inventory.supplier (
     ID bigint identity
    ,inventory_id bigint NOT NULL
    ,contact_id bigint NOT NULL
);

ALTER TABLE IF EXISTS inventory.supplier ADD FOREIGN KEY (inventory_id) REFERENCES inventory.inventory (id);
ALTER TABLE IF EXISTS inventory.supplier ADD FOREIGN KEY (contact_id) REFERENCES contacts.contact (id);

drop table if exists inventory.document;
create table if not exists inventory.document (
    id bigint identity
    ,inventory_id bigint NOT NULL
    ,name nvarchar(30)
    ,mime_type nvarchar(30)
    ,document blob
);

ALTER TABLE IF EXISTS inventory.document ADD FOREIGN KEY (inventory_id) REFERENCES inventory.inventory (id);


create schema if not exists invoices;
drop table if exists invoices.invoice;
create table if not exists invoices.invoice (

id bigint identity
,invoicenumber nvarchar(10)
,invoicedate timestamp
,customer nvarchar(500)
,shippingcost decimal(19,4)
,memo nvarchar(500)
,isPaid boolean default(0)
,isVoid boolean default(0)
,taxrate1 decimal(19,4)
,taxrate2 decimal(19,4)
,contact_id bigint NULL
,isQuote boolean default(0)

);

ALTER TABLE IF EXISTS invoices.invoice ADD FOREIGN KEY (contact_id) REFERENCES contacts.contact (id);


drop table if exists invoices.invoiceitems;
create table if not exists invoices.invoiceitems (
    id bigint identity,
    invoice_id bigint not null,
    inventory_id bigint null,
    quantity decimal(19,4) not null,
    code nvarchar(64),
    description nvarchar(120),
    note nvarchar(1000),
    unit_price decimal(19,4),
    unit_cost decimal(19,4),
    taxable1 decimal(19,4),
    taxable2 decimal(19,4),
    returnPeriodInDays int
    
);

ALTER TABLE IF EXISTS invoices.invoiceitems ADD FOREIGN KEY (invoice_id) REFERENCES invoices.invoice (id);
ALTER TABLE IF EXISTS invoices.invoiceitems ADD FOREIGN KEY (inventory_id) REFERENCES inventory.inventory (id);

drop schema if exists common;
create schema if not exists common;

drop table if exists common.countries;
create table if exists common.countries (
    id bigint identity
    ,country nvarchar(2)
    ,twoDigitCode nvarchar(2)
    ,threeDigitCode nvarchar(3)
    ,code nvarchar(3)
    ,name nvarchar(32)

);

drop schema if exists auth;
create schema if not exists auth;

drop table if exists auth.users;
create table if not exists auth.users(
    id bigint identity
    ,userid uuid not null default(RANDOM_UUID())
    ,password nvarchar(500)
    ,username nvarchar(120)
);


