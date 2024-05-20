import React, { useState } from 'react';
import './UpdatePolicyForm.css';

function UpdatePolicyForm() {
    const [policyNumber, setPolicyNumber] = useState('');
    const [expirationDate, setExpirationDate] = useState('');
    const [paymentStatus, setPaymentStatus] = useState('');

    const updateExpiration = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/policies/update-expiration?policyNumber=${policyNumber}&expirationDate=${expirationDate}`, {
                method: 'PUT'
            });
            if (!response.ok) {
                throw new Error(`Error: ${response.statusText}`);
            }
            const data = await response.json();
            console.log(data);
        } catch (error) {
            console.error('Failed to update expiration:', error);
        }
    };

    const updatePaymentStatus = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/policies/update-payment-status?policyNumber=${policyNumber}&paymentStatus=${paymentStatus}`, {
                method: 'PUT'
            });
            if (!response.ok) {
                throw new Error(`Error: ${response.statusText}`);
            }
            const data = await response.json();
            console.log(data);
        } catch (error) {
            console.error('Failed to update payment status:', error);
        }
    };

    return (
        <div className="container">
            <h2 className="title">Policy Management</h2>
            <div className="form-section">
                <h3>Update Policy Expiration</h3>
                <form onSubmit={(e) => { e.preventDefault(); updateExpiration(); }}>
                    <div className="form-group">
                        <label htmlFor="policyNumber">Policy Number:</label>
                        <input type="text" id="policyNumber" value={policyNumber} onChange={(e) => setPolicyNumber(e.target.value)} required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="expirationDate">Expiration Date:</label>
                        <input type="date" id="expirationDate" value={expirationDate} onChange={(e) => setExpirationDate(e.target.value)} required />
                    </div>
                    <button type="submit" className="submit-button">Update Expiration</button>
                </form>
            </div>
            <div className="form-section">
                <h3>Update Payment Status</h3>
                <form onSubmit={(e) => { e.preventDefault(); updatePaymentStatus(); }}>
                    <div className="form-group">
                        <label htmlFor="policyNumberStatus">Policy Number:</label>
                        <input type="text" id="policyNumberStatus" value={policyNumber} onChange={(e) => setPolicyNumber(e.target.value)} required />
                    </div>
                    <div className="form-group">
                        <label htmlFor="paymentStatus">Payment Status:</label>
                        <select id="paymentStatus" value={paymentStatus} onChange={(e) => setPaymentStatus(e.target.value)} required>
                            <option value="">Select Status</option>
                            <option value="paid">Paid</option>
                            <option value="unpaid">Unpaid</option>
                        </select>
                    </div>
                    <button type="submit" className="submit-button">Update Payment Status</button>
                </form>
            </div>
        </div>
    );
}

export default UpdatePolicyForm;
