# Todo Application

A full-stack Todo app with Spring Boot backend and React frontend. Features Slack notifications and OpenAI integration.

---

## Prerequisites

- Java 17+
- Maven
- Node.js & npm
- PostgreSQL or MySQL database
- Slack workspace with Incoming Webhook
- OpenAI API key

---

## Setup Instructions

### Backend

1. Clone repo and enter backend folder:
   ```bash
   git clone https://github.com/your_username/todo_application.git
   cd todo_application/Todo_Backend
2.Create .env from .env.example and update:
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/your_db
SPRING_DATASOURCE_USERNAME=your_db_user
SPRING_DATASOURCE_PASSWORD=your_db_password
OPENAI_API_KEY=your_openai_api_key
SLACK_WEBHOOK_URL=https://hooks.slack.com/services/your/slack/webhook
3.Run backend:
mvn spring-boot:run
Frontend
1.Go to frontend folder:

2.cd ../todo-slack-frontend
Create .env from .env.example, set backend API URL:
REACT_APP_BACKEND_URL=http://localhost:8081/api

3.Install dependencies and start:
npm install
npm start
4.Open http://localhost:3000 in browser.

1.Slack Setup
  Create Incoming Webhook in Slack App settings.
  Copy URL to SLACK_WEBHOOK_URL in backend .env.

2.OpenAI Setup
Get API key from OpenAI.
Add key to OPENAI_API_KEY in backend .env.

3.Design Overview
Backend: Spring Boot REST API + JPA for DB
Database: PostgreSQL/MySQL configurable
Frontend: React + Axios for API calls
Integrations: Slack webhook for notifications, OpenAI API for summaries

