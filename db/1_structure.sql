-- Création des tables pour journal_quete

-- Table caracteristique
CREATE TABLE IF NOT EXISTS caracteristique (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(80) NOT NULL,
  type CHAR(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nom (nom)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Table entite
CREATE TABLE IF NOT EXISTS entite (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(240) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nom (nom)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Table region
CREATE TABLE IF NOT EXISTS region (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(120) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nom (nom)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Table quete
CREATE TABLE IF NOT EXISTS quete (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(240) NOT NULL,
  description TEXT NOT NULL,
  ref_region INT(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nom (nom),
  KEY ref_region (ref_region),
  CONSTRAINT quete_ibfk_1 FOREIGN KEY (ref_region) REFERENCES region (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Table quete_detail
CREATE TABLE IF NOT EXISTS quete_detail (
  id INT(11) NOT NULL AUTO_INCREMENT,
  ref_quete INT(11) NOT NULL,
  ref_caracteristique INT(11) NOT NULL,
  valeur VARCHAR(240) NOT NULL,
  ref_entite INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY ref_quete (ref_quete),
  KEY ref_caracteristique (ref_caracteristique),
  KEY ref_entite (ref_entite),
  CONSTRAINT quete_detail_ibfk_1 FOREIGN KEY (ref_quete) REFERENCES quete (id),
  CONSTRAINT quete_detail_ibfk_2 FOREIGN KEY (ref_caracteristique) REFERENCES caracteristique (id),
  CONSTRAINT quete_detail_ibfk_3 FOREIGN KEY (ref_entite) REFERENCES entite (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
