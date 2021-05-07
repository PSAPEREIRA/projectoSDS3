import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {

    labels: string[];
    series: number[];
}

const DonutChart = () => {

    //Why not to use hooks - wrong implementation
    let chartData: ChartData = { labels: [], series: [] };

    /*const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
    */

    axios.get( BASE_URL + '/sales/amountBySeller')
        .then(response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(labelItem => labelItem.sellerName);
            const mySeries = data.map(seriesItem => seriesItem.sum);
            chartData = { labels: myLabels, series: mySeries }
            console.log(chartData);
         });

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;