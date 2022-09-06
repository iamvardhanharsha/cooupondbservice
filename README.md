CREATE TABLE `coupon`.`coupon` (
  `client` VARCHAR(45) NOT NULL,
  `couponcode` VARCHAR(45) NULL,
  `startdate` DATE NULL,
  `enddate` DATE NULL,
  PRIMARY KEY (`client`));

insert into coupon values ('phonepay','phonepay20','2022-09-06','2022-09-12');



http://localhost:8892/coupondb/getcoupon/phonepay


{
    "client": "phonepay",
    "couponCode": "phonepay20",
    "startDate": "2022-09-06",
    "endDate": "2022-09-12"
}
