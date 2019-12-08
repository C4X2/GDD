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

-- START MESSAGE_REGISTRY ENTRIES --
INSERT INTO MESSAGE_REGISTRY(message_key, description, message, created_date)
VALUES ("homepage","The header shown on the top of the webpage", "Game Desgin Document", CURDATE()),
 ("gddComment", "Explaination of what a GDD is.", "A Game Design Document, or GDD, defines every aspect of your game. Additionaly it acts as an orienting document for each stakeholder in your organization. As a GDD explicitly states the goals game development needs to meet , from the small technical requirements to the large conceptual challenges. Finally, A GDD is a resource for keeping a game true to its roots. If the game changes so should the GDD.", CURDATE()),
 ("contact_us", "Contact Us, header on the top of the webpage", "Contact Us", CURDATE()),
 ("license", "License, header on the top of the webpage", "License", CURDATE()),
 ("build", "Build, header on the top of the webpage", "Build Your Own", CURDATE()),
 ("about", "About, header on the top of the webpage", "About", CURDATE()),
 ("error", "Simple error message", "Error", CURDATE()),
 ("feedback_encouragement", "Encourage the user to give feedback.", "We care about your feedback!", CURDATE()),
 ("placeholder_user_input", "Placeholder text for the Contact Us page", "We care about your feedback!", CURDATE()),
 ("about_emerald", "About Page header", "About Emerald Softworks, Inc.", CURDATE()),
 ("home", "Home", "Home", CURDATE()),
 ("build_keyword", "The word build", "Build", CURDATE()),
 ("about_text", "A short description of Emerald Softworks, and it's CEO", "Emerald Softworks was founded in 2018 with a mission dedicated to providing open-source resources to game developers across the world.
	    			This site GDD, is one of the first fully produced sites developed by Emerald Softworks, Inc. however there is more on the way!
	    			The CEO and founder of Emerald Softworks, Inc. is Nate Brown who is currently working on his first game, Korlal, a JRPG developed in Unity Game Engine.
	    			We are always open for suggestions about how to better configure our services to better help others. So if you have any comments, recommendations or if
	    			you just want to reach out please feel free to", CURDATE());
-- END MESSAGE_REGISTRY ENTRIES --

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
    is_current_system bool,
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
