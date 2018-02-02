package testCase;

public class FourtyFiveVariable implements TestCase {


	private double[][] A = { 
			{50.0, 15.0, 82.0, 62.0, 70.0, 35.0, 32.0, 34.0, 99.0, 2.0, 45.0, 26.0, 67.0, 2.0, 80.0, 66.0, 75.0, 22.0, 61.0, 10.0, 47.0, 79.0, 1.0, 95.0, 59.0, 31.0, 36.0, 28.0, 85.0, 55.0, 88.0, 78.0, 31.0, 65.0, 99.0, 39.0, 77.0, 66.0, 84.0, 10.0, 28.0, 70.0, 71.0, 73.0, 8.0, },
			{30.0, 59.0, 85.0, 12.0, 26.0, 34.0, 63.0, 3.0, 27.0, 36.0, 32.0, 62.0, 89.0, 100.0, 67.0, 61.0, 70.0, 33.0, 47.0, 28.0, 69.0, 84.0, 24.0, 60.0, 5.0, 84.0, 79.0, 62.0, 52.0, 7.0, 53.0, 80.0, 81.0, 59.0, 73.0, 30.0, 81.0, 9.0, 46.0, 1.0, 48.0, 13.0, 65.0, 72.0, 44.0, },
			{84.0, 41.0, 51.0, 90.0, 12.0, 64.0, 33.0, 81.0, 90.0, 49.0, 45.0, 79.0, 86.0, 4.0, 85.0, 68.0, 68.0, 34.0, 84.0, 58.0, 50.0, 80.0, 38.0, 84.0, 87.0, 95.0, 90.0, 35.0, 90.0, 88.0, 69.0, 18.0, 92.0, 22.0, 26.0, 26.0, 88.0, 53.0, 50.0, 6.0, 45.0, 27.0, 76.0, 6.0, 35.0, },
			{58.0, 77.0, 14.0, 70.0, 29.0, 43.0, 30.0, 69.0, 35.0, 41.0, 41.0, 67.0, 94.0, 13.0, 46.0, 84.0, 30.0, 81.0, 17.0, 70.0, 3.0, 63.0, 87.0, 51.0, 25.0, 27.0, 84.0, 23.0, 85.0, 43.0, 10.0, 92.0, 65.0, 38.0, 34.0, 54.0, 92.0, 38.0, 36.0, 68.0, 45.0, 66.0, 65.0, 13.0, 88.0, },
			{64.0, 25.0, 32.0, 63.0, 24.0, 75.0, 9.0, 34.0, 5.0, 72.0, 43.0, 97.0, 80.0, 43.0, 95.0, 99.0, 28.0, 68.0, 23.0, 76.0, 89.0, 45.0, 100.0, 81.0, 81.0, 9.0, 87.0, 89.0, 21.0, 28.0, 2.0, 28.0, 72.0, 63.0, 96.0, 6.0, 83.0, 58.0, 2.0, 34.0, 53.0, 34.0, 98.0, 57.0, 94.0, },
			{12.0, 82.0, 14.0, 35.0, 91.0, 17.0, 21.0, 1.0, 77.0, 10.0, 84.0, 16.0, 1.0, 10.0, 50.0, 14.0, 39.0, 97.0, 86.0, 93.0, 69.0, 45.0, 5.0, 97.0, 61.0, 83.0, 80.0, 23.0, 40.0, 94.0, 44.0, 7.0, 29.0, 10.0, 53.0, 2.0, 40.0, 94.0, 62.0, 37.0, 39.0, 87.0, 71.0, 90.0, 87.0, },
			{17.0, 25.0, 49.0, 48.0, 15.0, 55.0, 62.0, 30.0, 6.0, 94.0, 6.0, 24.0, 63.0, 46.0, 14.0, 75.0, 40.0, 4.0, 81.0, 19.0, 54.0, 28.0, 3.0, 31.0, 89.0, 28.0, 19.0, 83.0, 12.0, 84.0, 28.0, 43.0, 19.0, 54.0, 94.0, 8.0, 83.0, 22.0, 20.0, 27.0, 93.0, 46.0, 98.0, 22.0, 59.0, },
			{19.0, 56.0, 22.0, 4.0, 39.0, 15.0, 87.0, 87.0, 24.0, 26.0, 71.0, 56.0, 71.0, 39.0, 85.0, 87.0, 66.0, 61.0, 78.0, 74.0, 20.0, 62.0, 72.0, 69.0, 35.0, 74.0, 39.0, 21.0, 40.0, 45.0, 45.0, 10.0, 31.0, 62.0, 26.0, 62.0, 86.0, 69.0, 87.0, 84.0, 87.0, 29.0, 44.0, 70.0, 26.0, },
			{55.0, 6.0, 84.0, 54.0, 62.0, 36.0, 92.0, 89.0, 76.0, 94.0, 10.0, 66.0, 5.0, 67.0, 25.0, 74.0, 11.0, 32.0, 85.0, 79.0, 67.0, 34.0, 34.0, 49.0, 51.0, 41.0, 46.0, 55.0, 98.0, 64.0, 54.0, 55.0, 36.0, 96.0, 21.0, 42.0, 83.0, 72.0, 43.0, 63.0, 91.0, 68.0, 14.0, 92.0, 57.0, },
			{22.0, 31.0, 50.0, 97.0, 7.0, 43.0, 2.0, 69.0, 23.0, 8.0, 39.0, 62.0, 83.0, 8.0, 16.0, 61.0, 72.0, 62.0, 52.0, 99.0, 28.0, 93.0, 32.0, 51.0, 91.0, 61.0, 55.0, 9.0, 76.0, 55.0, 68.0, 9.0, 5.0, 81.0, 93.0, 1.0, 70.0, 12.0, 72.0, 89.0, 36.0, 84.0, 54.0, 93.0, 79.0, },
			{66.0, 16.0, 4.0, 82.0, 32.0, 26.0, 67.0, 87.0, 89.0, 84.0, 31.0, 52.0, 31.0, 61.0, 82.0, 12.0, 99.0, 58.0, 46.0, 92.0, 49.0, 11.0, 17.0, 85.0, 89.0, 53.0, 62.0, 82.0, 62.0, 24.0, 91.0, 99.0, 77.0, 61.0, 21.0, 90.0, 5.0, 80.0, 88.0, 27.0, 87.0, 56.0, 67.0, 44.0, 89.0, },
			{72.0, 20.0, 66.0, 26.0, 74.0, 4.0, 50.0, 21.0, 63.0, 52.0, 76.0, 2.0, 50.0, 33.0, 81.0, 53.0, 18.0, 22.0, 97.0, 76.0, 2.0, 80.0, 87.0, 90.0, 48.0, 82.0, 46.0, 39.0, 6.0, 54.0, 34.0, 95.0, 5.0, 100.0, 48.0, 11.0, 5.0, 7.0, 91.0, 66.0, 39.0, 30.0, 58.0, 85.0, 38.0, },
			{30.0, 64.0, 79.0, 79.0, 13.0, 95.0, 24.0, 68.0, 30.0, 50.0, 61.0, 56.0, 89.0, 14.0, 7.0, 77.0, 5.0, 11.0, 73.0, 60.0, 7.0, 64.0, 78.0, 14.0, 90.0, 16.0, 64.0, 45.0, 16.0, 53.0, 40.0, 85.0, 92.0, 91.0, 6.0, 1.0, 72.0, 43.0, 20.0, 29.0, 11.0, 70.0, 19.0, 89.0, 37.0, },
			{25.0, 18.0, 38.0, 80.0, 26.0, 23.0, 49.0, 80.0, 20.0, 60.0, 74.0, 69.0, 21.0, 27.0, 30.0, 68.0, 17.0, 35.0, 52.0, 88.0, 3.0, 47.0, 26.0, 100.0, 4.0, 4.0, 19.0, 7.0, 20.0, 91.0, 7.0, 83.0, 69.0, 1.0, 59.0, 58.0, 32.0, 57.0, 12.0, 55.0, 51.0, 52.0, 23.0, 26.0, 93.0, },
			{83.0, 5.0, 72.0, 4.0, 92.0, 17.0, 30.0, 48.0, 14.0, 55.0, 31.0, 37.0, 5.0, 22.0, 5.0, 52.0, 35.0, 34.0, 45.0, 44.0, 62.0, 10.0, 80.0, 40.0, 86.0, 40.0, 4.0, 60.0, 3.0, 63.0, 55.0, 9.0, 51.0, 24.0, 3.0, 99.0, 78.0, 23.0, 69.0, 1.0, 92.0, 32.0, 11.0, 100.0, 38.0, },
			{28.0, 58.0, 88.0, 58.0, 65.0, 37.0, 13.0, 61.0, 71.0, 82.0, 3.0, 64.0, 94.0, 15.0, 37.0, 47.0, 9.0, 25.0, 80.0, 21.0, 1.0, 48.0, 50.0, 30.0, 99.0, 54.0, 43.0, 95.0, 12.0, 7.0, 92.0, 56.0, 63.0, 81.0, 95.0, 44.0, 1.0, 82.0, 47.0, 61.0, 72.0, 55.0, 65.0, 1.0, 74.0, },
			{77.0, 93.0, 3.0, 2.0, 47.0, 2.0, 36.0, 77.0, 98.0, 33.0, 66.0, 31.0, 61.0, 37.0, 59.0, 85.0, 99.0, 29.0, 86.0, 58.0, 60.0, 91.0, 20.0, 38.0, 61.0, 64.0, 10.0, 55.0, 32.0, 61.0, 43.0, 100.0, 96.0, 16.0, 85.0, 61.0, 58.0, 41.0, 67.0, 44.0, 6.0, 96.0, 54.0, 14.0, 33.0, },
			{80.0, 18.0, 57.0, 63.0, 51.0, 33.0, 70.0, 56.0, 36.0, 39.0, 36.0, 20.0, 91.0, 89.0, 3.0, 13.0, 63.0, 44.0, 16.0, 34.0, 2.0, 17.0, 6.0, 18.0, 26.0, 55.0, 66.0, 85.0, 35.0, 53.0, 76.0, 11.0, 27.0, 51.0, 53.0, 23.0, 5.0, 3.0, 85.0, 16.0, 83.0, 78.0, 58.0, 96.0, 31.0, },
			{65.0, 96.0, 13.0, 16.0, 17.0, 77.0, 58.0, 42.0, 19.0, 21.0, 18.0, 4.0, 89.0, 18.0, 36.0, 31.0, 63.0, 61.0, 95.0, 59.0, 78.0, 33.0, 56.0, 85.0, 11.0, 69.0, 14.0, 72.0, 51.0, 14.0, 6.0, 70.0, 90.0, 43.0, 45.0, 16.0, 50.0, 60.0, 28.0, 2.0, 92.0, 23.0, 43.0, 52.0, 35.0, },
			{77.0, 33.0, 86.0, 53.0, 14.0, 60.0, 63.0, 74.0, 12.0, 64.0, 18.0, 46.0, 98.0, 15.0, 50.0, 35.0, 90.0, 49.0, 55.0, 9.0, 19.0, 85.0, 78.0, 51.0, 49.0, 36.0, 57.0, 20.0, 34.0, 60.0, 93.0, 82.0, 71.0, 18.0, 57.0, 86.0, 38.0, 19.0, 12.0, 77.0, 47.0, 41.0, 16.0, 74.0, 42.0, },
			{22.0, 54.0, 10.0, 90.0, 73.0, 82.0, 74.0, 48.0, 64.0, 98.0, 100.0, 88.0, 30.0, 43.0, 73.0, 69.0, 55.0, 13.0, 74.0, 28.0, 90.0, 5.0, 46.0, 50.0, 59.0, 1.0, 13.0, 90.0, 18.0, 95.0, 55.0, 35.0, 76.0, 43.0, 8.0, 96.0, 66.0, 63.0, 11.0, 31.0, 43.0, 13.0, 85.0, 20.0, 59.0, },
			{96.0, 98.0, 97.0, 90.0, 8.0, 95.0, 95.0, 98.0, 72.0, 86.0, 100.0, 49.0, 95.0, 23.0, 53.0, 95.0, 79.0, 76.0, 76.0, 61.0, 5.0, 81.0, 91.0, 96.0, 81.0, 38.0, 78.0, 65.0, 95.0, 90.0, 50.0, 78.0, 48.0, 24.0, 92.0, 65.0, 11.0, 53.0, 46.0, 40.0, 39.0, 78.0, 54.0, 69.0, 70.0, },
			{99.0, 24.0, 97.0, 40.0, 29.0, 49.0, 9.0, 66.0, 81.0, 18.0, 79.0, 46.0, 87.0, 84.0, 96.0, 39.0, 22.0, 26.0, 42.0, 43.0, 25.0, 13.0, 62.0, 26.0, 83.0, 59.0, 65.0, 15.0, 60.0, 75.0, 87.0, 9.0, 77.0, 70.0, 86.0, 66.0, 43.0, 39.0, 83.0, 55.0, 51.0, 38.0, 64.0, 65.0, 85.0, },
			{38.0, 86.0, 50.0, 95.0, 48.0, 5.0, 37.0, 61.0, 92.0, 10.0, 12.0, 23.0, 3.0, 18.0, 30.0, 75.0, 28.0, 78.0, 80.0, 45.0, 72.0, 27.0, 21.0, 37.0, 37.0, 99.0, 51.0, 81.0, 18.0, 14.0, 86.0, 40.0, 57.0, 67.0, 11.0, 35.0, 8.0, 47.0, 51.0, 90.0, 86.0, 12.0, 57.0, 16.0, 9.0, },
			{54.0, 38.0, 28.0, 36.0, 3.0, 20.0, 39.0, 2.0, 73.0, 78.0, 67.0, 51.0, 7.0, 63.0, 29.0, 48.0, 77.0, 1.0, 17.0, 90.0, 88.0, 59.0, 64.0, 49.0, 70.0, 7.0, 47.0, 6.0, 42.0, 14.0, 89.0, 75.0, 37.0, 17.0, 69.0, 95.0, 1.0, 21.0, 63.0, 92.0, 39.0, 83.0, 70.0, 22.0, 97.0, },
			{50.0, 57.0, 94.0, 53.0, 2.0, 91.0, 41.0, 9.0, 38.0, 36.0, 96.0, 27.0, 78.0, 69.0, 40.0, 81.0, 23.0, 63.0, 15.0, 3.0, 21.0, 93.0, 53.0, 58.0, 42.0, 13.0, 26.0, 61.0, 77.0, 50.0, 80.0, 98.0, 30.0, 19.0, 57.0, 90.0, 85.0, 83.0, 12.0, 2.0, 98.0, 12.0, 25.0, 51.0, 64.0, },
			{2.0, 92.0, 45.0, 83.0, 83.0, 6.0, 76.0, 29.0, 1.0, 43.0, 83.0, 40.0, 8.0, 91.0, 91.0, 12.0, 21.0, 47.0, 17.0, 3.0, 80.0, 81.0, 76.0, 67.0, 12.0, 33.0, 66.0, 98.0, 96.0, 48.0, 25.0, 85.0, 82.0, 43.0, 1.0, 34.0, 67.0, 8.0, 77.0, 4.0, 20.0, 87.0, 63.0, 42.0, 18.0, },
			{88.0, 66.0, 80.0, 46.0, 55.0, 47.0, 54.0, 88.0, 34.0, 76.0, 14.0, 42.0, 43.0, 26.0, 84.0, 36.0, 64.0, 57.0, 90.0, 76.0, 8.0, 10.0, 78.0, 56.0, 80.0, 40.0, 60.0, 7.0, 40.0, 80.0, 48.0, 69.0, 69.0, 76.0, 14.0, 18.0, 46.0, 4.0, 90.0, 3.0, 51.0, 48.0, 7.0, 54.0, 10.0, },
			{69.0, 76.0, 52.0, 10.0, 43.0, 45.0, 80.0, 55.0, 15.0, 96.0, 58.0, 4.0, 95.0, 52.0, 65.0, 15.0, 47.0, 100.0, 34.0, 14.0, 95.0, 76.0, 91.0, 70.0, 23.0, 12.0, 61.0, 17.0, 54.0, 42.0, 39.0, 11.0, 48.0, 31.0, 32.0, 19.0, 91.0, 39.0, 26.0, 65.0, 17.0, 23.0, 45.0, 18.0, 73.0, },
			{47.0, 58.0, 98.0, 19.0, 99.0, 54.0, 46.0, 26.0, 67.0, 72.0, 10.0, 61.0, 80.0, 78.0, 44.0, 73.0, 59.0, 25.0, 97.0, 79.0, 61.0, 47.0, 44.0, 13.0, 61.0, 64.0, 8.0, 84.0, 64.0, 100.0, 3.0, 94.0, 43.0, 19.0, 48.0, 57.0, 36.0, 83.0, 34.0, 41.0, 40.0, 82.0, 23.0, 78.0, 49.0, },
			{82.0, 76.0, 25.0, 39.0, 93.0, 12.0, 17.0, 89.0, 87.0, 92.0, 98.0, 85.0, 71.0, 14.0, 44.0, 14.0, 73.0, 26.0, 34.0, 19.0, 7.0, 17.0, 77.0, 60.0, 86.0, 34.0, 44.0, 21.0, 48.0, 32.0, 41.0, 15.0, 48.0, 25.0, 71.0, 52.0, 99.0, 56.0, 51.0, 99.0, 10.0, 45.0, 49.0, 5.0, 17.0, },
			{51.0, 72.0, 19.0, 83.0, 97.0, 69.0, 63.0, 87.0, 30.0, 51.0, 86.0, 99.0, 18.0, 83.0, 40.0, 63.0, 5.0, 15.0, 24.0, 14.0, 6.0, 69.0, 83.0, 2.0, 2.0, 45.0, 68.0, 74.0, 80.0, 41.0, 3.0, 41.0, 2.0, 17.0, 47.0, 5.0, 66.0, 92.0, 82.0, 18.0, 74.0, 46.0, 60.0, 26.0, 33.0, },
			{30.0, 67.0, 74.0, 90.0, 99.0, 25.0, 86.0, 56.0, 53.0, 65.0, 46.0, 89.0, 3.0, 68.0, 25.0, 1.0, 20.0, 69.0, 40.0, 50.0, 42.0, 47.0, 92.0, 98.0, 10.0, 78.0, 28.0, 89.0, 58.0, 70.0, 30.0, 21.0, 10.0, 12.0, 85.0, 12.0, 27.0, 20.0, 30.0, 67.0, 65.0, 24.0, 95.0, 53.0, 4.0, },
			{66.0, 64.0, 12.0, 30.0, 21.0, 57.0, 18.0, 92.0, 62.0, 65.0, 29.0, 22.0, 14.0, 82.0, 87.0, 93.0, 37.0, 41.0, 84.0, 42.0, 73.0, 93.0, 81.0, 53.0, 37.0, 8.0, 31.0, 19.0, 49.0, 79.0, 51.0, 48.0, 63.0, 27.0, 41.0, 9.0, 61.0, 100.0, 99.0, 55.0, 45.0, 78.0, 58.0, 74.0, 90.0, },
			{79.0, 5.0, 73.0, 33.0, 54.0, 95.0, 42.0, 100.0, 29.0, 48.0, 93.0, 35.0, 45.0, 67.0, 62.0, 13.0, 23.0, 30.0, 93.0, 46.0, 94.0, 19.0, 22.0, 87.0, 54.0, 67.0, 42.0, 4.0, 64.0, 23.0, 86.0, 66.0, 64.0, 42.0, 11.0, 69.0, 52.0, 33.0, 42.0, 19.0, 98.0, 74.0, 16.0, 67.0, 93.0, },
			{57.0, 15.0, 18.0, 13.0, 18.0, 5.0, 40.0, 57.0, 7.0, 42.0, 41.0, 55.0, 1.0, 42.0, 26.0, 99.0, 86.0, 100.0, 42.0, 12.0, 34.0, 18.0, 33.0, 80.0, 68.0, 86.0, 4.0, 71.0, 73.0, 82.0, 52.0, 76.0, 55.0, 16.0, 94.0, 84.0, 15.0, 68.0, 4.0, 64.0, 65.0, 20.0, 5.0, 37.0, 5.0, },
			{7.0, 71.0, 55.0, 84.0, 37.0, 34.0, 11.0, 14.0, 91.0, 90.0, 75.0, 70.0, 82.0, 66.0, 56.0, 60.0, 87.0, 11.0, 74.0, 17.0, 43.0, 79.0, 33.0, 34.0, 96.0, 71.0, 31.0, 88.0, 64.0, 45.0, 23.0, 4.0, 88.0, 40.0, 64.0, 84.0, 94.0, 50.0, 34.0, 52.0, 66.0, 24.0, 99.0, 20.0, 75.0, },
			{44.0, 94.0, 31.0, 86.0, 56.0, 51.0, 45.0, 38.0, 95.0, 27.0, 50.0, 91.0, 77.0, 25.0, 26.0, 58.0, 60.0, 34.0, 41.0, 98.0, 65.0, 70.0, 36.0, 90.0, 30.0, 9.0, 83.0, 98.0, 50.0, 41.0, 54.0, 92.0, 12.0, 24.0, 43.0, 48.0, 2.0, 23.0, 97.0, 55.0, 53.0, 22.0, 11.0, 73.0, 76.0, },
			{16.0, 17.0, 70.0, 42.0, 20.0, 4.0, 17.0, 21.0, 48.0, 38.0, 77.0, 27.0, 70.0, 12.0, 44.0, 9.0, 65.0, 36.0, 48.0, 33.0, 27.0, 66.0, 84.0, 33.0, 93.0, 83.0, 69.0, 8.0, 23.0, 50.0, 16.0, 67.0, 94.0, 2.0, 69.0, 34.0, 20.0, 78.0, 32.0, 17.0, 60.0, 15.0, 47.0, 87.0, 67.0, },
			{25.0, 28.0, 52.0, 23.0, 33.0, 61.0, 31.0, 86.0, 6.0, 88.0, 78.0, 67.0, 100.0, 92.0, 90.0, 13.0, 85.0, 62.0, 44.0, 21.0, 21.0, 29.0, 82.0, 71.0, 13.0, 8.0, 12.0, 20.0, 91.0, 96.0, 91.0, 88.0, 53.0, 61.0, 40.0, 15.0, 66.0, 23.0, 14.0, 74.0, 31.0, 61.0, 4.0, 7.0, 27.0, },
			{85.0, 98.0, 77.0, 70.0, 27.0, 91.0, 27.0, 21.0, 92.0, 69.0, 96.0, 99.0, 61.0, 99.0, 58.0, 22.0, 32.0, 99.0, 12.0, 48.0, 100.0, 32.0, 72.0, 7.0, 72.0, 13.0, 57.0, 32.0, 66.0, 16.0, 14.0, 99.0, 38.0, 51.0, 38.0, 97.0, 93.0, 37.0, 5.0, 52.0, 5.0, 27.0, 68.0, 36.0, 2.0, },
			{53.0, 80.0, 91.0, 92.0, 75.0, 59.0, 30.0, 96.0, 5.0, 28.0, 52.0, 41.0, 66.0, 38.0, 73.0, 97.0, 66.0, 29.0, 71.0, 5.0, 59.0, 81.0, 85.0, 54.0, 74.0, 3.0, 24.0, 24.0, 44.0, 38.0, 2.0, 28.0, 35.0, 87.0, 7.0, 63.0, 100.0, 82.0, 72.0, 91.0, 90.0, 69.0, 52.0, 3.0, 24.0, },
			{42.0, 90.0, 71.0, 77.0, 26.0, 44.0, 36.0, 5.0, 53.0, 77.0, 26.0, 45.0, 97.0, 58.0, 53.0, 80.0, 50.0, 99.0, 43.0, 28.0, 99.0, 54.0, 97.0, 48.0, 100.0, 65.0, 51.0, 60.0, 69.0, 56.0, 73.0, 59.0, 64.0, 23.0, 3.0, 82.0, 50.0, 26.0, 29.0, 1.0, 50.0, 32.0, 14.0, 63.0, 27.0, },
			{93.0, 92.0, 63.0, 5.0, 78.0, 22.0, 37.0, 4.0, 4.0, 38.0, 40.0, 5.0, 26.0, 52.0, 26.0, 46.0, 65.0, 31.0, 23.0, 5.0, 41.0, 54.0, 12.0, 29.0, 76.0, 35.0, 87.0, 17.0, 3.0, 70.0, 63.0, 17.0, 83.0, 10.0, 85.0, 90.0, 20.0, 62.0, 22.0, 46.0, 32.0, 54.0, 97.0, 62.0, 85.0, },
			{7.0, 77.0, 74.0, 60.0, 37.0, 84.0, 51.0, 7.0, 48.0, 7.0, 91.0, 68.0, 3.0, 23.0, 97.0, 76.0, 78.0, 13.0, 87.0, 62.0, 86.0, 10.0, 62.0, 88.0, 11.0, 42.0, 81.0, 96.0, 49.0, 77.0, 70.0, 56.0, 72.0, 48.0, 47.0, 72.0, 23.0, 94.0, 65.0, 38.0, 13.0, 33.0, 7.0, 64.0, 63.0, }
	};
	private double[] b = {26.0, 94.0, 44.0, 63.0, 85.0, 86.0, 82.0, 49.0, 68.0, 74.0, 6.0, 47.0, 11.0, 16.0, 59.0, 85.0, 53.0, 49.0, 70.0, 4.0, 31.0, 2.0, 34.0, 92.0, 25.0, 74.0, 37.0, 89.0, 30.0, 81.0, 4.0, 8.0, 81.0, 50.0, 82.0, 35.0, 66.0, 9.0, 39.0, 87.0, 68.0, 79.0, 64.0, 14.0, 50.0, };

	@Override
	public double[][] getA() {
		// TODO Auto-generated method stub
		return A;
	}

	@Override
	public double[] getB() {
		// TODO Auto-generated method stub
		return b;
	}
	public void ThousandTime(int n) {
		for (int i = 0; i < b.length; ++i) {
			b[i] *= (1000 * n);
			for (int j = 0; j < b.length; ++j) {
				A[i][j] *= (1000 * n);
			}
		}
	}

	public FourtyFiveVariable() {

	}

}
