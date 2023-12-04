import React, { useState } from "react";

const initialFormData = {
    username: "",
    password: ""
}

const Login = () => {
    const [formData, setFormData] = useState(initialFormData);

    const handleChange = e => {
        return setFormData(currentFormData => ({
            ...currentFormData,
            [e.target.name]: e.target.value
        }))
    }

    const handleLogin = async () => {
        return fetch("http://localhost:5550/api/users/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(formData)
        })
        .then(async resp => {
            console.log(resp)
        })
        .catch(err => console.log(err))
    }

    return (
        <div className="flex justify-center items-center w-full h-full">
            <div className="flex flex-col justify-center items-center h-[700px] w-[500px] bg-blue-500 mt-20">
                <label>Username</label>
                <input className="m-5" onChange={handleChange} type="text" name="username" placeholder="Enter your username" />
                <label>Password</label>
                <input className="m-5" onChange={handleChange} type="password" name="password" placeholder="Enter your password" />
                <button onClick={handleLogin}>Log In</button>
            </div>
        </div>
    )
};

export default Login;