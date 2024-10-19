import smtplib
import time
from datetime import datetime, timedelta

def check_task_time(name, description, due_time, email):
    while True:
        current_time = datetime.now()
        if current_time >= due_time - timedelta(hours=1) and current_time < due_time:
            send_email(name, description, email)
            print(f"Reminder sent for task '{name}'") #says when email is sent
            break
        time.sleep(60)

#below is placeholder for actual email info/function

def send_email (task_name, task_description, receiver_email): # will get rid of later 
    EMAIL_ADDRESS = "debug@localhost"

    with smtplib.SMTP('localhost', 1025) as smtp:
        msg = f'Subject: {task_name}\n\n{task_description}'
        smtp.sendmail(EMAIL_ADDRESS, receiver_email, msg)


# below is test

send_email("Reminder", "This is your task reminder", "receiver@localhost")

TaskName = "Submit Hackathon"
TaskDescription = "Submit Hackathon Code to Gradescope to Get Extra Credit for CSO"
TaskDueDate = datetime.now() + timedelta(hours=1)
ReceiverEmail = "receiver@localhost"

check_task_time(TaskName, TaskDescription, TaskDueDate, ReceiverEmail)