"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.router = void 0;
const express_1 = __importDefault(require("express"));
const dbcp_1 = require("../db/dbcp");
exports.router = express_1.default.Router();
exports.router.delete('/:isbn', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const result = yield dbcp_1.datasource.query('DELETE FROM book WHERE isbn = ?', [req.params.isbn]);
    res.sendStatus(result.affectedRows ? 204 : 404);
}));
exports.router.patch('/:isbn', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    var _a;
    const book = req.body;
    if (!((_a = book.title) === null || _a === void 0 ? void 0 : _a.trim())) {
        res.sendStatus(400);
        return;
    }
    const result = yield dbcp_1.datasource.query("UPDATE book SET title = ? WHERE isbn = ?", [book.title, req.params.isbn]);
    res.sendStatus(result.affectedRows ? 204 : 404);
}));
