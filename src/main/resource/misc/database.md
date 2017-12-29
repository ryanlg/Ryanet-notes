```
CREATE DATABASE notes CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```


```
CREATE TABLE `notes` (
  `note_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `note_raw` LONGTEXT NOT NULL DEFAULT '',
  `note_html` LONGTEXT DEFAULT '',
  `note_date_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `note_date_modified` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`note_id`)
)  CHARSET=utf8;
```