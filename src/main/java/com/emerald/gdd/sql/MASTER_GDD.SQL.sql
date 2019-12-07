-- START MESSAGE_REGISTRY TABLE DEFINITION --
CREATE TABLE MESSAGE_REGISTRY (
    message_key  text,
    description  text,
    message      mediumtext,
    created_date date,
    update_date  date,
    retired_date date
    );
-- END MESSAGE_REGISTRY TABLE DEFINITION --

-- START LICENSE TABLE DEFINITION --
CREATE TABLE LICENSE (
    license_key  text,
    description  text,
    text      	mediumtext,
    link_to_def  text,
    created_date date,
    update_date  date,
    retired_date date
    );
-- END LICENSE TABLE DEFINITION --

-- START ENUM_LICENSE TABLE DEFINITION --
CREATE TABLE ENUM_LICENSE (
    license_key  text,
    description  text,
    text      	mediumtext,
    link_to_def  text,
    created_date date,
    update_date  date,
    retired_date date
    );
-- END ENUM_LICENSE TABLE DEFINITION --

-- START ENUM_GAME_PLATFORM TABLE DEFINITION --
CREATE TABLE ENUM_GAME_PLATFORM (
    name              varchar(20),
    abbreviated_name  varchar(10),
    developer         varchar(20),
    media             varchar(20),
    os                varchar(30),
    manufacturer      mediumtext,
    is_current_system bool
    link_to_def       text,
    release_date      date,
    created_date      date,
    update_date       date,
    retired_date      date
    );
-- END ENUM_GAME_PLATFORM TABLE DEFINITION --

-- START ENUM_ESRB TABLE DEFINITION --
CREATE TABLE ENUM_ESRB (
	rating           varchar(30),
	full_rating      varchar(45),
	description      varchar(200),
	created_date      date,
    update_date       date,
    retired_date      date
);
-- END   ENUM_ESRB TABLE DEFINITION --

-- START CONTACT_RECORD TABLE DEFINITION --
CREATE TABLE CONTACT_RECORD (
    reason            varchar(20),
    comment			  varchar(10),
    created_date      date,
    update_date       date,
    retired_date      date
    );
-- END ENUM_GAME_PLATFORM TABLE DEFINITION --
