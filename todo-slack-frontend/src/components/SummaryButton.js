import React from 'react';

const SummaryButton = ({ onSummarize }) => (
  <button type="button" className="summary-button" onClick={onSummarize}>
    Summarize & Send to Slack
  </button>
);

export default SummaryButton;
