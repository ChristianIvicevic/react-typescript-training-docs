document.querySelectorAll("[data-tooltip-text]").forEach((tooltip) => {
    tippy(tooltip, {
        content: tooltip.getAttributeNode("data-tooltip-text").value,
        placement: "top",
        maxWidth: "none",
        theme: "comsysto",
        popperOptions: {
            modifiers: {
                preventOverflow: {
                    escapeWithReference: true
                }
            }
        }
    });
});
