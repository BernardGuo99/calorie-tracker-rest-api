/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ning
 * Created: 02-Apr-2019
 */
insert into fit5046.APP_USER (user_id, firstname, surname, email, date_of_birth, gender, address, postcode, level_of_activity, steps_per_mile, height, weight)
        values ('1', 'Bernard', 'Guo', 'bernard.guo1994@gmail.com', date('1994-03-24'), 'M', '192 Glen Huntly Rd', '3000', 5, 2200, 178, 62);

insert into fit5046.APP_USER (user_id, firstname, surname, email, date_of_birth, gender, address, postcode, level_of_activity, steps_per_mile, height, weight)
        values ('2', 'Ning', 'Guo', 'nguo0001"student.monash.edu', date('1994-05-24'), 'M', '7 Dudley St', '3145', 4, 2150, 177, 65);

insert into fit5046.APP_USER (user_id, firstname, surname, email, date_of_birth, gender, address, postcode, level_of_activity, steps_per_mile, height, weight)
        values ('3', 'Ashitha', 'Joseph', '123@gmail.com', date('1995-03-24'), 'F', '92 Burke Rd', '3145', 3, 2350, 168, 52);

insert into fit5046.APP_USER (user_id, firstname, surname, email, date_of_birth, gender, address, postcode, level_of_activity, steps_per_mile, height, weight)
        values ('4', 'Girish', 'Srinivasa', '456@gmail.com', date('1993-03-24'), 'M', '35 Collin St', '3100', 5, 2120, 182, 78);

insert into fit5046.APP_USER (user_id, firstname, surname, email, date_of_birth, gender, address, postcode, level_of_activity, steps_per_mile, height, weight)
        values ('5', 'Lin', 'Zhang', '789@gmail.com', date('1998-03-24'), 'F', '58 Union St', '3200', 1, 2500, 158, 48);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('1', 'Apple, 2 3/4" diam', 'fruit', '1 each', 0, 81);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('2', 'Avocado, black or green skin', 'fruit', '1/2 cup', 11, 121);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('3', 'Bacon: turkey', 'meat', '1 slice', 2, 32);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('4', 'Bacon: pork', 'meat', '1 slice', 3, 36);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('5', 'Beets', 'vegetable', '1/2 cup', 0, 37);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('6', 'Broccoli', 'vegetable', '1/2 cup', 0, 26);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('7', 'Bread stick, 5" long', 'bread', '1 each', 1, 64);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('8', 'Bread pudding, with raisins', 'bread', '1/2 cup', 9, 217);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('9', 'Bread, rye: regular', 'bread', '1 slice', 1, 67);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('10', 'Celery', 'vegetable', '1/2 cup', 0, 13);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('11', 'Chicken breast', 'meat', '1 med', 3, 161);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('12', 'Coconut milk: regular', 'drink', '1 cup', 51, 473);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('13', 'Coconut milk: light', 'drink', '1 cup', 12, 144);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('14', 'Oyster', 'seafood', '20 pcs', 3, 84);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('15', 'Grape juice, unsweetened', 'drink', '3/4 cup', 0, 161);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('16', 'Ham hocks', 'meat', '1 pc', 5, 109);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('17', 'Kiwi', 'fruit', '1 med', 0, 46);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('18', 'Milk, whole', 'drink', '1 cup', 8, 150);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('19', 'Milk, skim', 'drink', '1 cup', 0, 86);

insert into fit5046.FOOD (food_id, food_name, category, service_unit, fat, calorie_amount)
        values ('20', 'Rabbit', 'meat', '3 oz', 7, 168);

insert into fit5046.CONSUMPTION (consumption_id, user_id, food_id, consumption_date, quantity)
        values ('1', '1', '1', date('2019-03-06'), 3);

insert into fit5046.CONSUMPTION (consumption_id, user_id, food_id, consumption_date, quantity)
        values ('2', '1', '5', date('2019-03-13'), 2);

insert into fit5046.CONSUMPTION (consumption_id, user_id, food_id, consumption_date, quantity)
        values ('3', '2', '7', date('2019-03-15'), 6);

insert into fit5046.CONSUMPTION (consumption_id, user_id, food_id, consumption_date, quantity)
        values ('4', '4', '13', date('2019-03-15'), 1);

insert into fit5046.CONSUMPTION (consumption_id, user_id, food_id, consumption_date, quantity)
        values ('5', '3', '16', date('2019-03-21'), 5);

insert into fit5046.CONSUMPTION (consumption_id, user_id, food_id, consumption_date, quantity)
        values ('6', '1', '2', date('2019-03-06'), 5);

insert into fit5046.CREDENTIAL (credential_id, user_id, user_name, password_hash, sign_up_date)
        values ('1', '1', 'Bernard', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', date('2019-02-01'));

insert into fit5046.CREDENTIAL (credential_id, user_id, user_name, password_hash, sign_up_date)
        values ('2', '2', 'Ning', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', date('2019-02-07'));

insert into fit5046.CREDENTIAL (credential_id, user_id, user_name, password_hash, sign_up_date)
        values ('3', '3', 'Ashitha', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', date('2019-03-06'));

insert into fit5046.CREDENTIAL (credential_id, user_id, user_name, password_hash, sign_up_date)
        values ('4', '4', 'Girish', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', date('2019-03-08'));

insert into fit5046.CREDENTIAL (credential_id, user_id, user_name, password_hash, sign_up_date)
        values ('5', '5', 'Lin', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', date('2019-03-11'));

insert into fit5046.REPORT (report_id, user_id, report_date, steps_taken, calories_consumed, calories_burned, calorie_goal)
        values ('1', '1', date('2019-03-07'), 3500, 2600, 1500, 500);

insert into fit5046.REPORT (report_id, user_id, report_date, steps_taken, calories_consumed, calories_burned, calorie_goal)
        values ('2', '2', date('2019-03-08'), 4000, 2200, 1350, 400);

insert into fit5046.REPORT (report_id, user_id, report_date, steps_taken, calories_consumed, calories_burned, calorie_goal)
        values ('3', '3', date('2019-03-14'), 8000, 2250, 2000, 250);

insert into fit5046.REPORT (report_id, user_id, report_date, steps_taken, calories_consumed, calories_burned, calorie_goal)
        values ('4', '4', date('2019-03-18'), 12000, 2550, 2200, 150);

insert into fit5046.REPORT (report_id, user_id, report_date, steps_taken, calories_consumed, calories_burned, calorie_goal)
        values ('5', '5', date('2019-03-20'), 5000, 2380, 2500, -500);

insert into fit5046.REPORT (report_id, user_id, report_date, steps_taken, calories_consumed, calories_burned, calorie_goal)
        values ('6', '1', date('2019-03-15'), 4000, 3000, 2500, 300);
