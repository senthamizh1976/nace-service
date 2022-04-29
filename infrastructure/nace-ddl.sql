SET sql_mode = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE nace_details(
    order_id            BIGINT  UNSIGNED NOT NULL,
    PRIMARY KEY (order_id),

    nace_level          TINYINT DEFAULT 0,
    code                VARCHAR(10),
    parent              VARCHAR(10),
    description         VARCHAR(200),
    item_includes       TEXT,
    item_also_includes  MEDIUMTEXT,
    rulings             VARCHAR(200),
    item_excludes       MEDIUMTEXT,
    ref_to_isic         VARCHAR(10),

    created_at          TIMESTAMP NOT NULL,
    updated_at          TIMESTAMP NOT NULLnace_details

) CHARACTER SET utf8mb4;
