package final_project_ood;

public class RestoreCommand implements ICommand{

	public RestoreCommand() {
		
	}
	
	@Override
	public void execute() {
		if(Store.getStoreInstance().getStoreBackup() == null) {
			System.out.println("Backup doesn't exist. Consider backing up the system.");
		}
		else {
			Store.getStoreInstance().restoreFromMemento(Store.getStoreInstance().getStoreBackup());
		}
	}

}
