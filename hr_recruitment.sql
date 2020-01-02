-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2020 at 09:21 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hr_recruitment`
--

-- --------------------------------------------------------

--
-- Table structure for table `achievement`
--

CREATE TABLE `achievement` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bpjs_kes`
--

CREATE TABLE `bpjs_kes` (
  `id` int(11) NOT NULL,
  `employee` int(11) NOT NULL,
  `id_clinic` int(11) NOT NULL,
  `id_doktergigi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

CREATE TABLE `candidate` (
  `id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `date_of_birth` date NOT NULL,
  `place_of_birth` varchar(50) NOT NULL,
  `nationality` varchar(50) NOT NULL,
  `marital_status` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `religion` varchar(25) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_family` varchar(20) NOT NULL,
  `name_family` varchar(50) NOT NULL,
  `current_address` text NOT NULL,
  `ktp` varchar(20) NOT NULL,
  `npwp` varchar(50) NOT NULL,
  `sim` varchar(10) DEFAULT NULL,
  `last_education` varchar(10) NOT NULL,
  `photo` varchar(100) NOT NULL,
  `expected_salary` int(10) NOT NULL,
  `cv` varchar(100) NOT NULL,
  `province` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`id`, `user`, `first_name`, `last_name`, `date_of_birth`, `place_of_birth`, `nationality`, `marital_status`, `gender`, `religion`, `address`, `phone`, `email`, `phone_family`, `name_family`, `current_address`, `ktp`, `npwp`, `sim`, `last_education`, `photo`, `expected_salary`, `cv`, `province`) VALUES
(1, 1, 'kiki', 'kikik', '1995-12-04', 'jakarta', 'indonesia', 'single', 'L', 'moslem', 'pulo gebang', '081932386885', 'kiki@gmail.com', '081932386743', 'jumatih', 'pulo gebang', '3175060412950001', '1212321313', NULL, 'S1', 'images.jpg', 10000000, 'cv.jpg', 1);

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `id` int(11) NOT NULL,
  `province` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`id`, `province`, `name`) VALUES
(1, 1, 'jakarta timur');

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE `education` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `school` int(11) NOT NULL,
  `university` int(11) DEFAULT NULL,
  `major` varchar(50) NOT NULL,
  `periode` varchar(10) NOT NULL,
  `ijazah` varchar(10) NOT NULL,
  `gpa` varchar(6) DEFAULT NULL,
  `education_degree` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `family`
--

CREATE TABLE `family` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `place_of_birth` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `last_education` varchar(10) NOT NULL,
  `job` varchar(50) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `salary` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `interview_schedule`
--

CREATE TABLE `interview_schedule` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `process_status` int(11) NOT NULL,
  `date` date NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `id` int(11) NOT NULL,
  `job_title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`id`, `job_title`) VALUES
(1, 'Programmer'),
(2, 'Marketing');

-- --------------------------------------------------------

--
-- Table structure for table `process_status`
--

CREATE TABLE `process_status` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `vacancy` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `process_status`
--

INSERT INTO `process_status` (`id`, `candidate`, `vacancy`, `status`) VALUES
(1, 1, 1, 2),
(2, 1, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`id`, `name`) VALUES
(1, 'Jekardah');

-- --------------------------------------------------------

--
-- Table structure for table `ptkp`
--

CREATE TABLE `ptkp` (
  `id` int(11) NOT NULL,
  `employee` int(11) NOT NULL,
  `vacancy` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `question` varchar(255) NOT NULL,
  `a` varchar(255) NOT NULL,
  `b` varchar(255) NOT NULL,
  `c` varchar(255) NOT NULL,
  `d` varchar(255) NOT NULL,
  `e` varchar(255) NOT NULL,
  `f` varchar(255) NOT NULL,
  `created` date NOT NULL,
  `answer` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `question`, `a`, `b`, `c`, `d`, `e`, `f`, `created`, `answer`) VALUES
(2, '24 20 16 12 = …', '6', '8', '4', '2', '0', '10', '2019-12-29', 'b'),
(3, '1 2 3 4 ...', '5', '6', '7', '8', '9', '10', '2019-12-29', 'a'),
(4, '2 4 6 8 ...', '12', '10', '13', '14', '15', '11', '2019-12-29', 'b'),
(5, '1 3 5 ... 9', '8', '10', '11', '7', '12', '6', '2019-12-29', 'd'),
(6, '0 3 6 9 ...', '10', '11 ', '12', '13', '14', '15', '2019-12-29', 'c'),
(7, '5 10 15 ... 25', '22', '30', '20', '12', '23', '24', '2019-12-29', 'c'),
(8, '10  8  6  4  ...  0', '1', '2', '3', '5', '7', '-1', '2019-12-30', 'b'),
(9, '4  8  12  ...  20', '13', '14', '15', '16', '17', '18', '2019-12-30', 'd'),
(10, '100  200  300  ...  500', '101', '301', '350', '360', '380', '400', '2019-12-30', 'f'),
(11, '0  4  2  6  ...', '1', '2', '7', '6', '4', '3', '2019-12-30', 'e');

-- --------------------------------------------------------

--
-- Table structure for table `relation`
--

CREATE TABLE `relation` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(20) NOT NULL,
  `job` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'Admin'),
(2, 'HR'),
(3, 'Candidate'),
(4, 'Accountant');

-- --------------------------------------------------------

--
-- Table structure for table `school`
--

CREATE TABLE `school` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `spring_session`
--

CREATE TABLE `spring_session` (
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `spring_session_attributes`
--

CREATE TABLE `spring_session_attributes` (
  `SESSION_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sub_district`
--

CREATE TABLE `sub_district` (
  `id` int(11) NOT NULL,
  `district` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `postal_code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sub_district`
--

INSERT INTO `sub_district` (`id`, `district`, `name`, `postal_code`) VALUES
(1, 1, 'cakung', '13960');

-- --------------------------------------------------------

--
-- Table structure for table `test_score`
--

CREATE TABLE `test_score` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `process_status` int(11) NOT NULL,
  `score` varchar(10) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `start_test` datetime DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `test_score`
--

INSERT INTO `test_score` (`id`, `candidate`, `process_status`, `score`, `type`, `start_date`, `end_date`, `start_test`, `status`) VALUES
(7, 1, 2, NULL, NULL, '2020-01-06 00:00:00', '2020-01-07 23:59:59', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `training`
--

CREATE TABLE `training` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `institute` varchar(50) NOT NULL,
  `name_of_training` text NOT NULL,
  `date` date NOT NULL,
  `certificate` varchar(10) NOT NULL,
  `score` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

CREATE TABLE `university` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `upload_file`
--

CREATE TABLE `upload_file` (
  `id` int(11) NOT NULL,
  `employee` int(11) NOT NULL,
  `ktp` varchar(100) DEFAULT NULL,
  `npwp` varchar(100) DEFAULT NULL,
  `bank_account` varchar(100) DEFAULT NULL,
  `tax_agreement` varchar(100) DEFAULT NULL,
  `jamsostek` varchar(100) DEFAULT NULL,
  `ijazah` varchar(100) DEFAULT NULL,
  `transkrip` varchar(100) DEFAULT NULL,
  `certificate` varchar(100) DEFAULT NULL,
  `skck` varchar(100) DEFAULT NULL,
  `domisili` varchar(100) DEFAULT NULL,
  `surat_sehat` varchar(100) DEFAULT NULL,
  `kk` varchar(100) DEFAULT NULL,
  `ticket` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `email`, `status`, `role`) VALUES
(1, 'kiki', 'kiki', 'kiki@gmail.com', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `vacancy`
--

CREATE TABLE `vacancy` (
  `id` int(11) NOT NULL,
  `jobs` int(11) NOT NULL,
  `company` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `status` int(11) NOT NULL,
  `expired` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vacancy`
--

INSERT INTO `vacancy` (`id`, `jobs`, `company`, `description`, `status`, `expired`) VALUES
(1, 1, 'MII', 'prgraommer', 1, '2020-04-24'),
(2, 2, 'MII', 'marketing', 1, '2020-02-13');

-- --------------------------------------------------------

--
-- Table structure for table `village`
--

CREATE TABLE `village` (
  `id` int(11) NOT NULL,
  `sub_district` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `village`
--

INSERT INTO `village` (`id`, `sub_district`, `name`) VALUES
(1, 1, 'ujung menteng');

-- --------------------------------------------------------

--
-- Table structure for table `working_exp`
--

CREATE TABLE `working_exp` (
  `id` int(11) NOT NULL,
  `candidate` int(11) NOT NULL,
  `company` varchar(50) NOT NULL,
  `position` varchar(50) NOT NULL,
  `start` date NOT NULL,
  `end` date NOT NULL,
  `address` text NOT NULL,
  `job_desc` text NOT NULL,
  `project_history` text NOT NULL,
  `reason_to_leave` text NOT NULL,
  `salary` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_achievement` (`candidate`);

--
-- Indexes for table `bpjs_kes`
--
ALTER TABLE `bpjs_kes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bpjskes` (`employee`);

--
-- Indexes for table `candidate`
--
ALTER TABLE `candidate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user` (`user`),
  ADD KEY `fk_province_cand` (`province`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_province` (`province`);

--
-- Indexes for table `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_education` (`candidate`),
  ADD KEY `fk_school` (`school`),
  ADD KEY `fk_university` (`university`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_candidate_emp` (`candidate`);

--
-- Indexes for table `family`
--
ALTER TABLE `family`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_family` (`candidate`);

--
-- Indexes for table `interview_schedule`
--
ALTER TABLE `interview_schedule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_interview_candidate` (`candidate`),
  ADD KEY `fk_interview_processstatus` (`process_status`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `process_status`
--
ALTER TABLE `process_status`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_process_statuscandidate` (`candidate`),
  ADD KEY `fk_process_statusjob` (`vacancy`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ptkp`
--
ALTER TABLE `ptkp`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ptkpcandidate` (`employee`),
  ADD KEY `id_ptkpvacancy` (`vacancy`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `relation`
--
ALTER TABLE `relation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_relation` (`candidate`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `school`
--
ALTER TABLE `school`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `spring_session`
--
ALTER TABLE `spring_session`
  ADD PRIMARY KEY (`SESSION_ID`),
  ADD KEY `SPRING_SESSION_IX1` (`LAST_ACCESS_TIME`);

--
-- Indexes for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD PRIMARY KEY (`SESSION_ID`,`ATTRIBUTE_NAME`),
  ADD KEY `SPRING_SESSION_ATTRIBUTES_IX1` (`SESSION_ID`);

--
-- Indexes for table `sub_district`
--
ALTER TABLE `sub_district`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_district` (`district`);

--
-- Indexes for table `test_score`
--
ALTER TABLE `test_score`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_testscore_candidate` (`candidate`),
  ADD KEY `fk_testscore_process` (`process_status`);

--
-- Indexes for table `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_training` (`candidate`);

--
-- Indexes for table `university`
--
ALTER TABLE `university`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `upload_file`
--
ALTER TABLE `upload_file`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_uploadfile` (`employee`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_role` (`role`);

--
-- Indexes for table `vacancy`
--
ALTER TABLE `vacancy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_jobs` (`jobs`);

--
-- Indexes for table `village`
--
ALTER TABLE `village`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_subdistrict` (`sub_district`);

--
-- Indexes for table `working_exp`
--
ALTER TABLE `working_exp`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_working` (`candidate`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achievement`
--
ALTER TABLE `achievement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bpjs_kes`
--
ALTER TABLE `bpjs_kes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `candidate`
--
ALTER TABLE `candidate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `district`
--
ALTER TABLE `district`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `education`
--
ALTER TABLE `education`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `family`
--
ALTER TABLE `family`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `interview_schedule`
--
ALTER TABLE `interview_schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `process_status`
--
ALTER TABLE `process_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ptkp`
--
ALTER TABLE `ptkp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `relation`
--
ALTER TABLE `relation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `school`
--
ALTER TABLE `school`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sub_district`
--
ALTER TABLE `sub_district`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `test_score`
--
ALTER TABLE `test_score`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `training`
--
ALTER TABLE `training`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `university`
--
ALTER TABLE `university`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `upload_file`
--
ALTER TABLE `upload_file`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `vacancy`
--
ALTER TABLE `vacancy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `village`
--
ALTER TABLE `village`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `working_exp`
--
ALTER TABLE `working_exp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `fk_achievement` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`);

--
-- Constraints for table `bpjs_kes`
--
ALTER TABLE `bpjs_kes`
  ADD CONSTRAINT `fk_bpjskes` FOREIGN KEY (`employee`) REFERENCES `employee` (`id`);

--
-- Constraints for table `candidate`
--
ALTER TABLE `candidate`
  ADD CONSTRAINT `fk_province_cand` FOREIGN KEY (`province`) REFERENCES `province` (`id`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`);

--
-- Constraints for table `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `fk_province` FOREIGN KEY (`province`) REFERENCES `province` (`id`);

--
-- Constraints for table `education`
--
ALTER TABLE `education`
  ADD CONSTRAINT `fk_education` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`),
  ADD CONSTRAINT `fk_school` FOREIGN KEY (`school`) REFERENCES `school` (`id`),
  ADD CONSTRAINT `fk_university` FOREIGN KEY (`university`) REFERENCES `university` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_candidate_emp` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`);

--
-- Constraints for table `family`
--
ALTER TABLE `family`
  ADD CONSTRAINT `fk_family` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`);

--
-- Constraints for table `interview_schedule`
--
ALTER TABLE `interview_schedule`
  ADD CONSTRAINT `fk_interview_candidate` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`),
  ADD CONSTRAINT `fk_interview_processstatus` FOREIGN KEY (`process_status`) REFERENCES `process_status` (`id`);

--
-- Constraints for table `process_status`
--
ALTER TABLE `process_status`
  ADD CONSTRAINT `fk_process_statuscandidate` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`),
  ADD CONSTRAINT `fk_process_statusjob` FOREIGN KEY (`vacancy`) REFERENCES `vacancy` (`id`);

--
-- Constraints for table `ptkp`
--
ALTER TABLE `ptkp`
  ADD CONSTRAINT `id_ptkpcandidate` FOREIGN KEY (`employee`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `id_ptkpvacancy` FOREIGN KEY (`vacancy`) REFERENCES `vacancy` (`id`);

--
-- Constraints for table `relation`
--
ALTER TABLE `relation`
  ADD CONSTRAINT `fk_relation` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`);

--
-- Constraints for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_ID`) REFERENCES `spring_session` (`SESSION_ID`) ON DELETE CASCADE;

--
-- Constraints for table `sub_district`
--
ALTER TABLE `sub_district`
  ADD CONSTRAINT `fk_district` FOREIGN KEY (`district`) REFERENCES `district` (`id`);

--
-- Constraints for table `test_score`
--
ALTER TABLE `test_score`
  ADD CONSTRAINT `fk_testscore_candidate` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`),
  ADD CONSTRAINT `fk_testscore_process` FOREIGN KEY (`process_status`) REFERENCES `process_status` (`id`);

--
-- Constraints for table `training`
--
ALTER TABLE `training`
  ADD CONSTRAINT `fk_training` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`);

--
-- Constraints for table `upload_file`
--
ALTER TABLE `upload_file`
  ADD CONSTRAINT `fk_uploadfile` FOREIGN KEY (`employee`) REFERENCES `employee` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`);

--
-- Constraints for table `vacancy`
--
ALTER TABLE `vacancy`
  ADD CONSTRAINT `fk_jobs` FOREIGN KEY (`jobs`) REFERENCES `jobs` (`id`);

--
-- Constraints for table `village`
--
ALTER TABLE `village`
  ADD CONSTRAINT `fk_subdistrict` FOREIGN KEY (`sub_district`) REFERENCES `sub_district` (`id`);

--
-- Constraints for table `working_exp`
--
ALTER TABLE `working_exp`
  ADD CONSTRAINT `fk_working` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
