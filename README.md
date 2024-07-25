**How to set-up**

docker build --t microservice-discovery .

docker run --name ms_discovery_container -p 8761:8761 microservice-discovery



docker build --t microservice-patient .

docker run --name ms_patient_container -p 8081:8081 microservice-patient



docker build --t microservice-note .

docker run --name ms_note_container -p 8082:8082 microservice-note



docker build --t microservice-report .

docker run --name ms_patient_report -p 8083:8083 microservice-report

**Microservice-patient**

Service has the functionality to add/inquire/delete/update the patient information.  The patient information is stored in postgres DB

![image](https://github.com/user-attachments/assets/b8099c44-d237-48fd-beac-9cc2448b88fd)
 
Get Mappings

http://localhost:8081/patient/family-name/Ferguson

{
    "id": 1,
    "name": "Ferguson",
    "firstName": "Lucas",
    "sex": "M",
    "birthday": "1968-06-22",
    "address": "2 Warren Street ",
    "phone": "387-866-1399"
}

http://localhost:8081/patient/1

{
    "id": 7,
    "name": "Wilson",
    "firstName": "Claire",
    "sex": "F",
    "birthday": "1966-12-31",
    "address": "12 Cobblestone St",
    "phone": "300-452-1091"
}

Post Mapping

http://10.0.0.174:8081/patient/add?family=Ferguson&given=Lucas&dob=1968-06-22&sex=M&address=2 Warren Street &phone=387-866-1399

Put Mapping

http://10.0.0.174:8081/patient

Request body

{
    "id": 1,
    "name": "Ferguson",
    "firstName": "Lucas",
    "sex": "M",
    "birthday": "1968-06-22",
    "address": "2 Warren Street ",
    "phone": "387-866-1399"
}

Delete Mapping

http://10.0.0.174:8081/patient/1




**Microservice-note**

Microservice note service can accept freeform provider notes and the notes are attached to idPatient.
Provider notes is stored in mangoDB
 
Get mapping and sample response

http://localhost:8082/patHistory/1

{
    "id": 1,
    "note": "\"Patient states that they are \"\"feeling terrific\"\"\nWeight at or below recommended level\n\"",
    "idPatient": 1
}

http://localhost:8082/patHistory/patient/1

[
    {
        "id": 1,
        "note": "\"Patient states that they are \"\"feeling terrific\"\"\nWeight at or below recommended level\n\"",
        "idPatient": 1
    },
    {
        "id": 2,
        "note": "\"Patient states that they feel tired during the day\nPatient also complains about muscle aches\nLab reports Microalbumin elevated\n\"\n",
        "idPatient": 1
    },
    {
        "id": 3,
        "note": "\"Patient states that they not feeling as tired\nSmoker, quit within last year\nLab results indicate Antibodies present elevated\n\"\n",
        "idPatient": 1
    }
]

Post Mapping 

http://localhost:8082/patHistory/add?patId=3&note=Lab reports Microalbumin elevated

Put Mapping

http://localhost:8082/patHistory

Request body

{
    "id": 1,
    "note": "\"Patient states that they are \"\"feeling terrific\"\"\nWeight at or below recommended level\n\"",
    "idPatient": 1
}

Delete Mapping

http://localhost:8082/patHistory/1





**Microservice-report**

Microservice report service will access patient notes and access risk level based on the trigger terms that match the patient notes.
Additional service also has the endpoints to accept various trigger terms and store them in mango DB

![image](https://github.com/user-attachments/assets/5f0334e9-dba6-4839-8fe1-5492ebb43708)


Endpoints

Post Mapping
http://localhost:8083/trigger

Request body

{
    "triggerCriteria": "Abnormal",
    "created": "2024-07-23"
}

Get Mapping
http://localhost:8083/trigger

[
    {
        "id": 1,
        "triggerCriteria": "Hemoglobin A1C",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 2,
        "triggerCriteria": "Microalbumin",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 3,
        "triggerCriteria": "Body Height",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 4,
        "triggerCriteria": "Body Weight",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 5,
        "triggerCriteria": "Smoker",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 6,
        "triggerCriteria": "Abnormal",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 7,
        "triggerCriteria": "Cholesterol",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 8,
        "triggerCriteria": "Dizziness",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 9,
        "triggerCriteria": "Relapse",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 10,
        "triggerCriteria": "Reaction",
        "created": "2024-07-23T00:00:00.000+00:00"
    },
    {
        "id": 11,
        "triggerCriteria": "Antibodies",
        "created": "2024-07-23T00:00:00.000+00:00"
    }
]


Report service and sample response

http://localhost:8083/assess/familyName?familyName=Ferguson
http://localhost:8083/assess/id?patId=8

{
    "id": 18,
    "idPatient": 8,
    "risk": "Borderline",
    "description": "Patient: Buckland Max (age 79) diabetes assessment is: Borderline",
    "patient": {
        "id": 8,
        "name": "Buckland",
        "firstName": "Max",
        "birthday": "1945-06-24T00:00:00.000+00:00",
        "sex": "M",
        "address": "193 Vale St",
        "phone": "833-534-0864",
        "age": 79
    }
}

Sample report

[{
  "_id": 1,
  "idPatient": 1,
  "risk": "None",
  "description": "Patient: Ferguson Lucas (age 56) diabetes assessment is: None",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 2,
  "idPatient": 2,
  "risk": "Early onset",
  "description": "Patient: Rees Pippa (age 71) diabetes assessment is: Early onset",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 3,
  "idPatient": 3,
  "risk": "Early onset",
  "description": "Patient: Arnold Edward (age 71) diabetes assessment is: Early onset",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 4,
  "idPatient": 3,
  "risk": "Early onset",
  "description": "Patient: Arnold Edward (age 71) diabetes assessment is: Early onset",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 5,
  "idPatient": 4,
  "risk": "None",
  "description": "Patient: Sharp Anthony (age 77) diabetes assessment is: None",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 6,
  "idPatient": 5,
  "risk": "Early onset",
  "description": "Patient: Ince Wendy (age 66) diabetes assessment is: Early onset",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 7,
  "idPatient": 6,
  "risk": "None",
  "description": "Patient: Ross Tracey (age 74) diabetes assessment is: None",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 8,
  "idPatient": 7,
  "risk": "Borderline",
  "description": "Patient: Wilson Claire (age 57) diabetes assessment is: Borderline",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 9,
  "idPatient": 8,
  "risk": "Borderline",
  "description": "Patient: Buckland Max (age 79) diabetes assessment is: Borderline",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 10,
  "idPatient": 9,
  "risk": "None",
  "description": "Patient: Clark Natalie (age 60) diabetes assessment is: None",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 11,
  "idPatient": 10,
  "risk": "None",
  "description": "Patient: Bailey Piers (age 65) diabetes assessment is: None",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 12,
  "idPatient": 3,
  "risk": "Early onset",
  "description": "Patient: Arnold Edward (age 71) diabetes assessment is: Early onset",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 13,
  "idPatient": 1,
  "risk": "None",
  "description": "Patient: Ferguson Lucas (age 56) diabetes assessment is: None",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 14,
  "idPatient": 6,
  "risk": "None",
  "description": "Patient: Ross Tracey (age 74) diabetes assessment is: None",
  "_class": "com.mediscreen.report.entity.Report"
},
{
  "_id": 15,
  "idPatient": 2,
  "risk": "Early onset",
  "description": "Patient: Rees Pippa (age 71) diabetes assessment is: Early onset",
  "_class": "com.mediscreen.report.entity.Report"
}]
