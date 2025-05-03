# Product Requirement Document (PRD)

---

## 1. Project Overview

**Product Name:** SkillForge  
**Author:** S. Koushik Kumar  
**Date:** 03-05-2025  

**Purpose:**  
SkillForge is an AI-integrated, real-time collaborative learning platform designed to help students, job-seekers, and developers connect, practice, and improve their skills together. The platform combines mock interviews, resume feedback, peer-to-peer coding, and AI mentoring in one seamless experience.

**Vision:**  
To create a unified learning hub that empowers users to skill up fast through collaboration, structured feedback, and AI-assisted coaching — simulating the support system found in top tech environments.

---

## 2. Problem Statement

- Fragmented learning tools (mock interviews, resume reviews, project work)
- Lack of real-time collaboration and team-based practice
- Difficulty accessing experienced mentors affordably

---

## 3. Goals & Objectives

- Real-time collaborative coding and communication
- AI-driven resume/code feedback
- Peer and mentor-based mock interviews
- Skill matchmaking for collaboration
- Project-based learning with feedback

---

## 4. Target Audience

- Students preparing for tech interviews  
- Self-taught developers  
- Bootcamp graduates  
- Job-seekers wanting to upskill  
- Tech mentors  

---

## 5. User Stories

- As a **learner**, I want to request help on code problems in real-time  
- As a **mentor**, I want to view code and guide users  
- As a **job-seeker**, I want AI to improve my resume  
- As a **developer**, I want to collaborate on peer projects  
- As a **user**, I want to attend mock interviews  

---

## 6. Core Features

| Module                     | Description |
|---------------------------|-------------|
| Authentication            | Role-based sign-up/login (learner, mentor, admin) |
| Real-Time Collaboration   | Live code editor, video chat, messaging |
| AI Resume & Code Review   | Feedback from AI tools (OpenAI/Gemini) |
| Mock Interviews           | Timed challenges, scoring, peer evaluation |
| Matchmaking Engine        | AI-based user pairing |
| Project Collaboration     | Rooms for building full-stack projects |
| Dashboard                 | Stats, growth, feedback, resume updates |

---

## 7. Technology Stack

| Layer     | Tech |
|-----------|------|
| Frontend  | React.js, Tailwind CSS, WebRTC, Socket.io |
| Backend   | Spring Boot (microservices), Spring Security |
| Database  | PostgreSQL, Redis |
| AI        | OpenAI / Gemini |
| DevOps    | Docker, GitHub Actions, Nginx, AWS |
| Docs      | Swagger, Notion, Lucidchart |

---

## 8. Success Metrics (KPIs)

- Match completion time (<10 seconds)
- Resume review quality (user rating)
- Interview session completion rate
- Daily Active Users (DAUs)
- Projects per user

---

## 9. Milestones (8-Week Timeline)

| Week | Task |
|------|------|
| 1    | PRD, Repo Setup, Auth Service |
| 2    | Profile + Roles |
| 3    | Matchmaking Engine |
| 4    | Collaboration Module |
| 5    | AI Review System |
| 6    | Interview Flow |
| 7    | Dashboard + Projects |
| 8    | Testing + Deployment |

---

## 10. Future Enhancements

- Mobile app (React Native)
- Leaderboards and achievements
- GitHub integration
- AI code debugger
