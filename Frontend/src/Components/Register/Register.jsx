import { Form } from "formik";
import React from "react";
import "./Register.css";

const Register = () => {
  return (
    <div>
      <div class="flex">
        <div>
            <img
            className="h-[80vh]"
          src="https://i.pinimg.com/736x/ab/65/26/ab65264c811d9556275f4ccec925d514.jpg"
          alt=" Homepage"
        />
        </div>
        
        <div class="">
          <img
            src="https://i.pinimg.com/736x/ab/65/26/ab65264c811d9556275f4ccec925d514.jpg"
            alt="Logo"
          />

          <form>
            <input type="text" placeholder="Username" />
            <input type="password" placeholder="Password" />
            <button type="submit">Log In</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Register;
