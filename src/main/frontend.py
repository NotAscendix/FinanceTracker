import streamlit as st
import requests

res = requests.get("http://localhost:8080/api/finance")
data = res.json()

st.title("FinanceTracker")

option = st.selectbox('Add, update or delete a transaction.',('Create new', 'Update', 'Delete'))
st.dataframe(data)

if(option == "Create new"):

    with st.form("create_transaction"):
        name = st.text_input("Transaction Name")
        amount = st.number_input("Transaction Amount")
        category = st.text_input("Transaction category")
        date = st.date_input("Transaction date: YYYY/MM/DD")
        transactionDate = date.isoformat()
        submitted = st.form_submit_button("Enter")

    payload = {
        "transactionName": name,
        "transactionAmount": amount,
        "transactionCategory": category,
        "transactionDate": transactionDate
    }

    if(submitted):
        response = requests.post(
        "http://localhost:8080/api/finance",
        json=payload
        )
        st.write("Status:", response.status_code)
        st.write("Response:", response.text)

if(option == "Update"):
    with st.form("update_transaction"):
        idVal = st.number_input("Enter id value: ", min_value = 1, step = 1)
        name = st.text_input("Update Transaction Name")
        amount = st.number_input("Update Transaction Amount")
        category = st.text_input("Update Transaction category")
        date = st.date_input("Update Transaction date: YYYY/MM/DD")
        transactionDate = date.isoformat()
        st.form_submit_button("Enter")

    payload = {
        "transactionName": name,
        "transactionAmount": amount,
        "transactionCategory": category,
        "transactionDate": transactionDate
    }

    response = requests.put(
    f"http://localhost:8080/api/finance/{idVal}",
    json=payload
    )
    st.write("Status:", response.status_code)
    st.write("Response:", response.text)

if(option == "Delete"):
    with st.form("delete_transaction"):
        idVal = st.number_input("Enter id value: ", min_value = 1, step = 1)
        submitted = st.form_submit_button("Delete")

    if submitted:
        response = requests.delete(
            f"http://localhost:8080/api/finance/{idVal}",
        )    


        st.write("Status:", response.status_code)
        st.write("Response:", response.text)