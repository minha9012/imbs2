import React, { useState, useEffect } from 'react';
import axios from 'axios'; // 액시오스

function Signup() {
    const [id, setId] = useState(0);

    function stateTest() {
        setId(id+1)
    }

    function getAxios(){
        axios(
            {
                url: '/user/test',
                method: 'GET',
                baseURL: 'http://localhost:8080',
                //withCredentials: true,
            }
        ).then(function (response) {
            console.log(response.data)
            alert(response.data);
            // console.log(response.data.JavaData[0].NICKNAME)
        });
    }
    function postAxios(){
        axios(
            {
                url: '/user/signup.do',
                method: 'post',
                data: {
                    email:'test@naver.com',aaa:'aaa222'
                } ,

                baseURL: 'http://localhost:8080',
                //withCredentials: true,
            }
        ).then(function (response) {
            console.log(response.data)
            // console.log(response.data.JavaData[0].NICKNAME)
        });
    }

    return (
        <div>
            test{id}
            <button  onClick={()=> stateTest()}>test</button>
            <br/>
            <button  onClick={()=> getAxios()}>axios get Test</button>
            <br/>
            <button  onClick={()=> postAxios()}>axios post Test</button>
        </div>
    );
}

export default Signup;