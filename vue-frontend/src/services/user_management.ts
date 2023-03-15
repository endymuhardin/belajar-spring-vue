export class UserManagementService {
    
    private urlUserList = "/api/user/";

    public async findUsers() : Promise<Page<User>> {
        return fetch(import.meta.env.VITE_BACKEND_URL + this.urlUserList)
                .then(response => Promise.resolve(response.json()))
    }
}