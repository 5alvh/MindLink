/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.services;

import com.mindlink.models.Appointment;
import com.mindlink.models.Payment;

/**
 *
 * @author madtore
 */
public interface PaymentService {

    Payment createPayment(Appointment appointment, double amount);

}
