const commonUtils = {
    init: function() {

    },
    changeDate(codeNum) {
        let date;
        switch(Number(codeNum)) {
            case 1: // 어제
                date = commonUtils.getYesterday();
                break;
            case 2: // 금일
                date = commonUtils.getToday();
                break;
            case 3: // 이번주
                date = commonUtils.getThisWeek();
                break;
            case 4: // 지난달
                date = commonUtils.getLastMonth();
                break;
            case 5: // 이번달
                date = commonUtils.getThisMonth();
                break;
        }
        // document.getElementById('date-picker').value = date[0];
        // document.getElementById('date-picker-2').value = date[1];
    },
    getYesterday() {
        const yesterday = new Date();
        yesterday.setDate(yesterday.getDate() - 1);
        return commonUtils.formatDateRange(yesterday, yesterday);
    },
    getToday() {
        const today = new Date();
        return commonUtils.formatDateRange(today, today);
    },
    getThisWeek() {
        const today = new Date();
        const dayOfWeek = today.getDay(); // 일요일 = 0, 월요일 = 1, ...
        const startOfWeek = new Date(today);
        const endOfWeek = new Date(today);
        startOfWeek.setDate(today.getDate() - dayOfWeek); // 이번 주의 시작 (일요일)
        endOfWeek.setDate(today.getDate() + (6 - dayOfWeek)); // 이번 주의 끝 (토요일)
        return commonUtils.formatDateRange(startOfWeek, endOfWeek);
    },
    getThisMonth() {
        const today = new Date();
        const startOfMonth = new Date(today.getFullYear(), today.getMonth(), 1); // 이번 달의 1일
        const endOfMonth = new Date(today.getFullYear(), today.getMonth() + 1, 0); // 이번 달의 마지막 날
        return commonUtils.formatDateRange(startOfMonth, endOfMonth);
    },
    getLastMonth() {
        const today = new Date();
        const startOfLastMonth = new Date(today.getFullYear(), today.getMonth() - 1, 1); // 지난 달의 1일
        const endOfLastMonth = new Date(today.getFullYear(), today.getMonth(), 0); // 지난 달의 마지막 날
        return commonUtils.formatDateRange(startOfLastMonth, endOfLastMonth);
    },
    formatDateRange(startDate, endDate) {
        const format = (date) => {
            const year = date.getFullYear();
            const month = String(date.getMonth() + 1).padStart(2, '0');
            const day = String(date.getDate()).padStart(2, '0');
            return `${year}-${month}-${day}`;
        };
        return [format(startDate), format(endDate)];
    },
}

commonUtils.init();