package final_project_ood;

public class BackupCommand implements ICommand{
	
	public BackupCommand() {
	}
	
	@Override
	public void execute() {
		Store.getStoreInstance().setStoreBackup(Store.getStoreInstance().createMemento());
	}

}
