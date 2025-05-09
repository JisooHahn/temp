CREATE SEQUENCE SEQ_COMPANY;
CREATE TABLE TBL_COMPANY
(
    ID                       NUMBER         NOT NULL
        CONSTRAINT PK_COMPANY
            PRIMARY KEY,
    COMPANY_BUSINESS_NUMBER  VARCHAR2(1000) NOT NULL,
    COMPANY_ESTABLISHMENT    DATE,
    COMPANY_CEO              VARCHAR2(1000) NOT NULL,
    COMPANY_EMPLOYEE         NUMBER,
    COMPANY_MAIN_ADDRESS     VARCHAR2(1000) not null,
    COMPANY_SUB_ADDRESS      VARCHAR2(1000) NOT NULL,
    COMPANY_LOGO_PATH        VARCHAR2(1000),
    COMPANY_URL              VARCHAR2(1000),
    COMPANY_CERTIFICATE_PATH VARCHAR2(1000) not null,
    COMPANY_INTRODUCE        VARCHAR2(1000),
    COMPANY_WELFARE          VARCHAR2(1000),
    COMPANY_CULTURE          VARCHAR2(1000),
    CREATED_DATE             DATE default SYSDATE,
    UPDATED_DATE             DATE default SYSDATE,
    COMPANY_NAME             VARCHAR2(1000)
);

ALTER TABLE TBL_COMPANY ADD COMPANY_MAIN_ADDRESS VARCHAR2(1000);
ALTER TABLE TBL_COMPANY ADD COMPANY_SUB_ADDRESS VARCHAR2(1000);