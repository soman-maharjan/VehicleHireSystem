import login.LoginView;

public class VehicleHireSystem {
	public static void main(String[] args) {
//		LoginView view = new LoginView();
		VehicleHireSystemView view = new VehicleHireSystemView();
		VehicleHireSystemModel model = new VehicleHireSystemModel();
		VehicleHireSystemController controller = new VehicleHireSystemController(view, model);
	}
}
