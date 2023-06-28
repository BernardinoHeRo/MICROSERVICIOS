CREATE TABLE `cat_estados`
(
    `idestado` INT UNSIGNED NOT NULL,
    `estado`   VARCHAR(31) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
    PRIMARY KEY (`idestado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cat_municipios`
(
    `idmunicipio` INT UNSIGNED NOT NULL,
    `idestado`    INT UNSIGNED NOT NULL,
    `municipio`   VARCHAR(49) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
    PRIMARY KEY (`idmunicipio`, `idestado`),
    KEY           `fk_cat_municipios_cat_estados1_idx` (`idestado`),
    CONSTRAINT `fk_cat_municipios_cat_estados1` FOREIGN KEY (`idestado`) REFERENCES `cat_estados` (`idestado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cat_cp`
(
    `idcp`        INT UNSIGNED NOT NULL DEFAULT '0',
    `idmunicipio` INT UNSIGNED NOT NULL,
    `idestado`    INT UNSIGNED NOT NULL,
    `cp`          MEDIUMINT                                                  NOT NULL,
    `colonia`     VARCHAR(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
    PRIMARY KEY (`idcp`),
    KEY           `fk_cat_cp_cat_municipios1_idx` (`idmunicipio`),
    KEY           `fk_cat_cp_cat_estados1_idx` (`idestado`),
    KEY           `cp` (`cp`),
    CONSTRAINT `fk_cat_cp_cat_estados1` FOREIGN KEY (`idestado`) REFERENCES `cat_estados` (`idestado`),
    CONSTRAINT `fk_cat_cp_cat_municipios1` FOREIGN KEY (`idmunicipio`) REFERENCES `cat_municipios` (`idmunicipio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
