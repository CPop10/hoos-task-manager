import smtplib
import os
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

email_subject = "X" #getting rid of later
email_body = "Y" #getting rid of later
email_receiver = "C" #getting rid of later
def send_email (task_name, task_description receiver_email): # will get rid of later 
    EMAIL_ADDRESS = os.environ.get('EMAIL_USER')
    EMAIL_PASSWORD = os.environ.get('EMAIL_PASS')

    with smtplib.SMTP('smtp@gmail.com', 587) as smtp:
        smtp.ehlo()
        smtp.starttls()
        smtp.ehlo()
        smtp.login(EMAIL_ADDRESS, EMAIL_ADDRESS)
        msg = f'Subject: {task_name}/n/n{task_description}'
        smtp.sendmail(EMAIL_ADDRESS, receiver_email, msg)