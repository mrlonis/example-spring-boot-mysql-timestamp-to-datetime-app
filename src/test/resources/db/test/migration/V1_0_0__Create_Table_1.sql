CREATE TABLE TEST_TABLE_1 (
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(100) NOT NULL,
  CREATED_DATETIME TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CREATED_USER VARCHAR(8) NOT NULL,
  UPDATED_DATETIME TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UPDATED_USER VARCHAR(8) NOT NULL
);
