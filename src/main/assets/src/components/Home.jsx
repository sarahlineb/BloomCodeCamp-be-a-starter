import React from "react";
import { Link } from "react-router-dom";
import '../App.css';

const Home = () => {
    return (
        <div className="flex flex-col justify-center items-center w-full">
            <div className="flex justify-center items-center text-center h-[100px] w-full">
            <h1 className="text-6xl"> Welcome To The Assignment Review App</h1>
            </div>
            <div className="flex flex-col justify-center items-center">
                <div className="flex flex-row"> 
                    <div className="h-[300px] w-[300px] bg-blue-500 m-10" />
                    <div className="flex justify-center items-center h-[300px] w-[300px] bg-blue-500 m-10" />
                    <div className="h-[300px] w-[300px] bg-blue-500 m-10" />
                </div>
                <div className="flex justify-center items-center">
                    <Link to="/login" className="rounded px-8 py-4 bg-blue-100">Login</Link>
                </div>
            </div>
            <div className="flex justify-center items-center text-center">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vel urna justo. Etiam lacinia, ante ac rhoncus placerat, arcu enim convallis ipsum, et efficitur leo elit a nibh. Morbi non sodales mauris. Quisque at quam ut metus pulvinar tempor. Proin et massa ipsum. Sed dignissim massa eu aliquet dignissim. Cras lacinia mauris eget bibendum finibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras blandit risus ac turpis pellentesque lacinia. Vivamus ut pulvinar elit, et ullamcorper tellus. Nulla pharetra felis vitae bibendum malesuada. Duis quis justo egestas lectus vulputate feugiat. Aliquam finibus volutpat ex, elementum porta ligula dignissim ac. In hac habitasse platea dictumst. Suspendisse dapibus, leo eget auctor facilisis, est lacus pretium leo, vitae tempor ante mi ornare lorem.</p> 
            </div>
            <div className="flex flex-row w-full justify-between">
            <p className="m-20">Sed nec ex vel sem</p> 
            <p className="m-20">Sed nec ex vel sem</p>
            <p className="m-20">Sed nec ex vel sem</p>
            <p className="m-20">Sed nec ex vel sem</p>
            </div>
        </div> 
    )
};

export default Home;