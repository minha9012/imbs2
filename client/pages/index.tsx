import React, { useState } from "react";
import Link from 'next/link';

export default function Home() {

    return (
        <div className="container">
            <div>
                <br/>
                <Link href='/about'><a>go to about page</a></Link>
                <br/>
                <Link href='/user/signup'><a>signup</a></Link>
                <br/>
                <div>Hello, Next!</div>
            </div>
        </div>
    );
}